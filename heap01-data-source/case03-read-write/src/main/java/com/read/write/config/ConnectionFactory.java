package com.read.write.config;

import com.read.write.entity.ConnectionEntity;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Component
public class ConnectionFactory {

    private volatile Map<String, Connection> connectionMap = new HashMap<>();

    @Resource
    private JdbcConfig jdbcConfig ;

    @PostConstruct
    public void init (){
        ConnectionEntity read = new ConnectionEntity(
        "MySql","jdbc:mysql://localhost:3306/data_read","user01","123");
        if (jdbcConfig.getConnection(read) != null){
            connectionMap.put(JdbcConstant.READ,jdbcConfig.getConnection(read));
        }
        ConnectionEntity write = new ConnectionEntity(
        "MySql","jdbc:mysql://localhost:3306/data_write","user01","123");
        if (jdbcConfig.getConnection(write) != null){
            connectionMap.put(JdbcConstant.WRITE,jdbcConfig.getConnection(write));
        }
    }

    public Connection getByKey (final String key){
        return connectionMap.get(key) ;
    }
}
