package com.ckhouse.cluster.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFactory {

    private volatile List<JdbcTemplate> jdbcTemplates = new ArrayList<>() ;

    @Resource
    private JdbcParamConfig jdbcParamConfig ;

    @PostConstruct
    public void init(){
        String[] urlArr = jdbcParamConfig.getUrlArray() ;
        for (String url:urlArr){
            DataSource dataSource = getDataSource(url) ;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource) ;
            jdbcTemplates.add(jdbcTemplate) ;
        }
    }

    public List<JdbcTemplate> getJdbcList (){
        return jdbcTemplates ;
    }

    private DataSource getDataSource(String url) {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setDriverClassName(jdbcParamConfig.getDriverClassName());
        datasource.setInitialSize(jdbcParamConfig.getInitialSize());
        datasource.setMinIdle(jdbcParamConfig.getMinIdle());
        datasource.setMaxActive(jdbcParamConfig.getMaxActive());
        datasource.setMaxWait(jdbcParamConfig.getMaxWait());
        return datasource;
    }

}
