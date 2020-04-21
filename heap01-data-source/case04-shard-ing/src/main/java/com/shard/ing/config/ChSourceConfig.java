package com.shard.ing.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

@Component
public class ChSourceConfig {

    public volatile Map<String, String[]> chSourceMap = new HashMap<>();
    public volatile Map<String, Connection> connectionMap = new HashMap<>();

    @Value("${spring.datasource.ch-data01.url}")
    private String dbUrl01;
    @Value("${spring.datasource.ch-data01.tables}")
    private String tables01 ;

    @Value("${spring.datasource.ch-data02.url}")
    private String dbUrl02;
    @Value("${spring.datasource.ch-data02.tables}")
    private String tables02 ;

    @PostConstruct
    public void init (){
        try{
            Connection connection01 = getConnection(dbUrl01);
            if (connection01 != null){
                chSourceMap.put(connection01.getCatalog(),tables01.split(","));
                connectionMap.put(connection01.getCatalog(),connection01);
            }
            Connection connection02 = getConnection(dbUrl02);
            if (connection02 != null){
                chSourceMap.put(connection02.getCatalog(),tables02.split(","));
                connectionMap.put(connection02.getCatalog(),connection02);
            }
        } catch (Exception e){e.printStackTrace();}
    }

    private synchronized Connection getConnection (String jdbcUrl) {
        try {
            DriverManager.setLoginTimeout(10);
            return DriverManager.getConnection(jdbcUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }

}
