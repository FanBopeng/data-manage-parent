package com.service.data.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    @Value("${spring.datasource.dataOne.url}")
    private String masterUrl;
    @Value("${spring.datasource.dataOne.username}")
    private String masterUsername;
    @Value("${spring.datasource.dataOne.password}")
    private String masterPassword;

    @Value("${spring.datasource.dataTwo.url}")
    private String slaveUrl;
    @Value("${spring.datasource.dataTwo.username}")
    private String slaveUsername;
    @Value("${spring.datasource.dataTwo.password}")
    private String slavePassword;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Bean
    public DataSource oneDataSource() {
        return getDefDataSource(masterUrl,masterUsername,masterPassword);
    }

    @Bean
    public JdbcTemplate jdbcTemplateOne (){
        return new JdbcTemplate(oneDataSource()) ;
    }

    @Bean
    public DataSource twoDataSource() {
        return getDefDataSource(slaveUrl,slaveUsername,slavePassword);
    }

    @Bean
    public JdbcTemplate jdbcTemplateTwo (){
        return new JdbcTemplate(twoDataSource()) ;
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
