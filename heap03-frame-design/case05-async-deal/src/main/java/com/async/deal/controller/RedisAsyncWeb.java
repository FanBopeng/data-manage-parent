package com.async.deal.controller;

import com.async.deal.service.RedisAsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订阅模式下异步处理
 */
@RestController
public class RedisAsyncWeb {

    @Resource
    private RedisAsyncService redisAsyncService ;

    @GetMapping("/sendMsg")
    public String sendMsg (){
        String topic = "topic:msg" ;
        String msg = "Hello...Redis,结束";
        redisAsyncService.sendMsg(topic,msg);
        return "Success" ;
    }
}
