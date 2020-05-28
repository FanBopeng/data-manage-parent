package com.cache.redis.service.impl;

import com.cache.redis.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<Object,Object> redisTemplate ;

    @Override
    public boolean set(Object key, Object value) {
        boolean redisFlag = true ;
        try {
            redisTemplate.opsForValue().set(key,value);
        } catch (Exception e){
            redisFlag = false ;
            e.printStackTrace();
        }
        return redisFlag ;
    }

    @Override
    public boolean set(Object key,Object value, long expire) {
        boolean redisFlag = true ;
        try {
            redisTemplate.opsForValue().set(key,value,expire, TimeUnit.SECONDS);
        } catch (Exception e){
            redisFlag = false ;
            e.printStackTrace();
        }
        return redisFlag ;
    }

    @Override
    public String get(Object key) {
        String value = null ;
        try {
            value = String.valueOf(redisTemplate.opsForValue().get(key)) ;

        } catch (Exception e){
            e.printStackTrace();
        }
        return value ;
    }

    @Override
    public boolean delete(Object key) {
        return redisTemplate.delete(key);
    }

    @Override
    public Properties info(String var) {
        if (StringUtils.isEmpty(var)){
            return redisTemplate.getRequiredConnectionFactory().getConnection().info();
        }
        return redisTemplate.getRequiredConnectionFactory().getConnection().info(var);
    }

}