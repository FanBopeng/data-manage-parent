package com.async.deal.controller;

import com.async.deal.service.KafkaAsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 生产消费模式下异步处理
 */
@RestController
public class KafkaAsyncWeb {

    @Resource
    private KafkaAsyncService kafkaAsyncService ;

    @GetMapping("/send")
    public String sendMsg () {
        kafkaAsyncService.sendMsg("kafka-msg");
        return "success" ;
    }

}
