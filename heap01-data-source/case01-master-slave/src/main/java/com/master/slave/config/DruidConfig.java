package com.master.slave.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @Value("${spring.datasource.master.url}")
    private String masterUrl;
    @Value("${spring.datasource.master.username}")
    private String masterUsername;
    @Value("${spring.datasource.master.password}")
    private String masterPassword;

    @Value("${spring.datasource.slave.url}")
    private String slaveUrl;
    @Value("${spring.datasource.slave.username}")
    private String slaveUsername;
    @Value("${spring.datasource.slave.password}")
    private String slavePassword;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Bean
    @Primary
    public DataSource primaryDataSource() {
        Map<Object, Object> map = new HashMap<>();
        map.put("masterDataSource", masterDataSource());
        map.put("slaveDataSource", slaveDataSource());
        RouteDataSource routeDataSource = new RouteDataSource();
        routeDataSource.setTargetDataSources(map);
        routeDataSource.setDefaultTargetDataSource(masterDataSource());
        return routeDataSource ;
    }

    private DataSource masterDataSource() {
        return getDefDataSource(masterUrl,masterUsername,masterPassword);
    }

    private DataSource slaveDataSource() {
        return getDefDataSource(slaveUrl,slaveUsername,slavePassword);
    }

    private DataSource getDefDataSource (String url,String userName,String passWord){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setDriverClassName(driverClassName);
        datasource.setUrl(url);
        datasource.setUsername(userName);
        datasource.setPassword(passWord);
        return datasource;
    }
}
