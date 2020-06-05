package com.async.deal.service.impl;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer02 {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer02.class);

    @KafkaListener(topics = "kafka-topic")
    public void listenMsg (ConsumerRecord<?,String> record) {
        String value = record.value();
        LOGGER.info("KafkaConsumer02 ==>>"+value);
    }
}
