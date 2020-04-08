package com.dynamic.add.service.impl;

import com.dynamic.add.config.DataSourceFactory;
import com.dynamic.add.config.JdbcConfig;
import com.dynamic.add.entity.ConnectionEntity;
import com.dynamic.add.mapper.ConnectionMapper;
import com.dynamic.add.service.ConnectionService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.sql.Connection;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Resource
    private ConnectionMapper connectionMapper ;
    @Resource
    private JdbcConfig jdbcConfig ;
    @Resource
    private DataSourceFactory dataSourceFactory ;

    @Override
    public boolean testConnection(ConnectionEntity connectionEntity) {
        return jdbcConfig.getConnection(connectionEntity) !=null ;
    }

    @Override
    public boolean addConnection(ConnectionEntity connectionEntity) {
        Connection connection = jdbcConfig.getConnection(connectionEntity) ;
        if (connection !=null){
            int addFlag = connectionMapper.insert(connectionEntity);
            if (addFlag > 0){
                dataSourceFactory.addDataSource(connectionEntity) ;
                return true ;
            }
        }
        return false ;
    }
}
