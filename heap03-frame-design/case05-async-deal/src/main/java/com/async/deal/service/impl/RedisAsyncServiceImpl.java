package com.async.deal.service.impl;

import com.async.deal.service.RedisAsyncService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class RedisAsyncServiceImpl implements RedisAsyncService {

    @Resource
    private StringRedisTemplate stringRedisTemplate ;

    @Override
    public void sendMsg(String topic, String msg) {
        stringRedisTemplate.convertAndSend(topic,msg);
    }
}
