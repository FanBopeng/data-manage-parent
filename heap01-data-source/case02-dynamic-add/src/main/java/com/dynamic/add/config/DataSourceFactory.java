package com.dynamic.add.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dynamic.add.entity.ConnectionEntity;
import com.dynamic.add.mapper.ConnectionMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JDBC 动态链接
 */
@Component
public class DataSourceFactory {

    private volatile Map<Integer, DataSource> dataSourceMap = new HashMap<>();

    @Resource
    private JdbcConfig jdbcConfig ;
    @Resource
    private ConnectionMapper connectionMapper ;

    /**
     * 初始化 JDBC 链接API
     */
    @PostConstruct
    public void init (){
        List<ConnectionEntity> connectionList = connectionMapper.getAllList();
        if (connectionList != null && connectionList.size()>0){
            for (ConnectionEntity connectionEntity:connectionList) {
                Connection connection = jdbcConfig.getConnection(connectionEntity) ;
                if (connection != null){
                    DataSource dataSource = getDataSource(connectionEntity);
                    dataSourceMap.put(connectionEntity.getId(),dataSource) ;
                }
            }
        }
    }

    /**
     * 数据源API包装
     */
    private static DataSource getDataSource (ConnectionEntity connectionEntity){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(connectionEntity.getJdbcUrl());
        datasource.setUsername(connectionEntity.getUserName());
        datasource.setPassword(connectionEntity.getPassWord());
        datasource.setDriverClassName(connectionEntity.getDriverClassName());
        return datasource ;
    }

    /**
     * 获取 JDBC 链接
     */
    public JdbcTemplate getById (Integer id){
        return new JdbcTemplate(dataSourceMap.get(id)) ;
    }

    /**
     * 移除 数据源
     */
    public void removeById (Integer id) {
        dataSourceMap.remove(id) ;
    }

    /**
     * 添加数据源管理
     * 注意这里的方法，连接验证之后直接调用
     */
    public void addDataSource (ConnectionEntity connectionEntity){
        DataSource dataSource = getDataSource(connectionEntity);
        dataSourceMap.put(connectionEntity.getId(),dataSource) ;
    }
}
