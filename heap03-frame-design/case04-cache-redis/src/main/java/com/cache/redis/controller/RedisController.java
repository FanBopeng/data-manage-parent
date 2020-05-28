package com.cache.redis.controller;

import com.cache.redis.entity.KeyValueEntity;
import com.cache.redis.service.KeyValueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class RedisController {

    @Resource
    private KeyValueService keyValueService ;

    @GetMapping("/select")
    public KeyValueEntity select (Integer id) {
        return keyValueService.select(id) ;
    }

    @GetMapping("/update")
    public boolean update (Integer id){
        KeyValueEntity keyValue = new KeyValueEntity() ;
        keyValue.setId(id);
        keyValue.setCacheKey("redis-0518-key");
        keyValue.setCacheValue("redis-0518-value");
        keyValue.setCreateTime(new Date());
        keyValue.setUpdateTime(new Date());
        return keyValueService.update(keyValue);
    }

}
