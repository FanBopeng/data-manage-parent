package com.cache.redis.controller;

import com.cache.redis.entity.MonitorEntity;
import com.cache.redis.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@RestController
public class MonitorController {

    @Resource
    private RedisService redisService ;

    private static final String[] monitorParam = new String[]{"memory","server","clients","stats","cpu"} ;

    @GetMapping("/monitor")
    public List<MonitorEntity> monitor (){
        List<MonitorEntity> monitorEntityList = new ArrayList<>() ;
        for (String param:monitorParam){
            Properties properties = redisService.info(param) ;
            MonitorEntity monitorEntity = new MonitorEntity () ;
            monitorEntity.setMonitorParam(param);
            monitorEntity.setProperties(properties);
            monitorEntityList.add(monitorEntity);
        }
        return monitorEntityList ;
    }

}
