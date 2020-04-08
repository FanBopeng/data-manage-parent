package com.dynamic.add.controller;

import com.dynamic.add.config.DataSourceFactory;
import com.dynamic.add.entity.ConnectionEntity;
import io.swagger.annotations.Api;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@Api(value = "JdbcQueryController")
@RestController
public class JdbcQueryController {

    @Resource
    private DataSourceFactory dataSourceFactory ;

    @GetMapping("getList")
    public List<ConnectionEntity> getList (@RequestParam("id") Integer id){
        String sql = "SELECT * FROM jm_connection WHERE state='1'" ;
        JdbcTemplate jdbcTemplate = dataSourceFactory.getById(id);
        List<ConnectionEntity> connectionEntities = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(ConnectionEntity.class));
        return connectionEntities ;
    }
}
