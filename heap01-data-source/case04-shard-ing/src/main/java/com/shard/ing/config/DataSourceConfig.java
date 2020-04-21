package com.shard.ing.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.shard.ing.shard.DataSourceAlg;
import com.shard.ing.shard.TableSignAlg;
import io.shardingsphere.api.config.rule.ShardingRuleConfiguration;
import io.shardingsphere.api.config.rule.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.data00.url}")
    private String dbUrl00;
    @Value("${spring.datasource.data00.username}")
    private String username00;
    @Value("${spring.datasource.data00.password}")
    private String password00;
    @Value("${spring.datasource.data00.driverClassName}")
    private String driverClassName00;

    @Value("${spring.datasource.data01.url}")
    private String dbUrl01;
    @Value("${spring.datasource.data01.username}")
    private String username01;
    @Value("${spring.datasource.data01.password}")
    private String password01;
    @Value("${spring.datasource.data01.driverClassName}")
    private String driverClassName01;

    @Value("${spring.datasource.data02.url}")
    private String dbUrl02;
    @Value("${spring.datasource.data02.username}")
    private String username02;
    @Value("${spring.datasource.data02.password}")
    private String password02;
    @Value("${spring.datasource.data02.driverClassName}")
    private String driverClassName02;

    private DruidDataSource getDataSource (String dbUrl,String username,
                                          String password,String driverClassName) {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        return datasource;
    }
    @Bean
    public DruidDataSource dataZeroSource() {
        return getDataSource(dbUrl00,username00,password00,driverClassName00);
    }
    @Bean
    public DruidDataSource dataOneSource() {
        return getDataSource(dbUrl01,username01,password01,driverClassName01);
    }
    @Bean
    public DruidDataSource dataTwoSource() {
        return getDataSource(dbUrl02,username02,password02,driverClassName02);
    }

    /**
     * 分库配置
     */
    @Bean
    public DataSource dataSource (@Autowired DruidDataSource dataZeroSource,
                                  @Autowired DruidDataSource dataOneSource,
                                  @Autowired DruidDataSource dataTwoSource) throws Exception {
        ShardingRuleConfiguration shardJdbcConfig = new ShardingRuleConfiguration();
        shardJdbcConfig.getTableRuleConfigs().add(getUserTableRule());
        shardJdbcConfig.setDefaultDataSourceName("ds_0");
        Map<String,DataSource> dataMap = new LinkedHashMap<>() ;
        dataMap.put("ds_0",dataZeroSource) ;
        dataMap.put("ds_1",dataOneSource) ;
        dataMap.put("ds_2",dataTwoSource) ;
        Properties prop = new Properties();
        return ShardingDataSourceFactory.createDataSource(dataMap, shardJdbcConfig, new HashMap<>(), prop);
    }

    /**
     * 分表配置
     */
    private static TableRuleConfiguration getUserTableRule () {
        TableRuleConfiguration result = new TableRuleConfiguration();
        result.setLogicTable("user_info");
        result.setActualDataNodes("ds_${1..2}.user_info_${0..2}");
        result.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_phone", new DataSourceAlg()));
        result.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_phone", new TableSignAlg()));
        return result;
    }
}
