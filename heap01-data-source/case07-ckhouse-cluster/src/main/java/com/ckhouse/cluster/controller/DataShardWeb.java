package com.ckhouse.cluster.controller;

import com.ckhouse.cluster.config.JdbcFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DataShardWeb {

    @Resource
    private JdbcFactory jdbcFactory ;

    /**
     * 基础表结构创建
     */
    @GetMapping("/createTable")
    public String createTable (){
        List<JdbcTemplate> jdbcTemplateList = jdbcFactory.getJdbcList();
        for (JdbcTemplate jdbcTemplate:jdbcTemplateList){
            jdbcTemplate.execute("CREATE TABLE data_shard (FlightDate Date,Year UInt16) ENGINE = MergeTree(FlightDate, (Year, FlightDate), 8192)");
            jdbcTemplate.execute("CREATE TABLE data_all AS data_shard ENGINE = Distributed(clickhouse_cluster, default, data_shard, rand())");
        }
        return "success" ;
    }

    /**
     * 节点表写入数据
     */
    @GetMapping("/insertData")
    public String insertData (){
        List<JdbcTemplate> jdbcTemplateList = jdbcFactory.getJdbcList();
        for (JdbcTemplate jdbcTemplate:jdbcTemplateList){
            jdbcTemplate.execute("insert into data_shard (FlightDate,Year) values ('2020-04-12',2020)");
        }
        return "success" ;
    }

}
