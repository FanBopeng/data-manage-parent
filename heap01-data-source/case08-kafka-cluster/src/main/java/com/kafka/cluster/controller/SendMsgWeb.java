package com.kafka.cluster.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMsgWeb {

    @Resource
    private KafkaProducer<String,String> producer ;

    @GetMapping("/sendMsg")
    public String sendMsg (){
        producer.send(new ProducerRecord<>("one-topic", "msgKey", "msgValue"));
        return "success" ;
    }
}
