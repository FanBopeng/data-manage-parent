package com.async.deal.service.impl;

import com.async.deal.service.KafkaAsyncService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class KafkaAsyncServiceImpl implements KafkaAsyncService {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMsg(String msg) {
        // 这里Topic如果不存在，会自动创建
        kafkaTemplate.send("kafka-topic", msg);
    }
}
