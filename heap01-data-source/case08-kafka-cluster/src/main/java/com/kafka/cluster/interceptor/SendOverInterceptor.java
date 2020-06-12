package com.kafka.cluster.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class SendOverInterceptor implements ProducerInterceptor<String, String> {

    private final Logger LOGGER = LoggerFactory.getLogger("SendOverInterceptor");
    @Override
    public void configure(Map<String, ?> configs) {
        LOGGER.info("configs...");
    }

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        LOGGER.info("record...{}", record.value());
        return record ;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        if (exception != null){
            LOGGER.info("Send Fail...exe-msg",exception.getMessage());
        }
        LOGGER.info("Send success...");
    }

    @Override
    public void close() {
        LOGGER.info("SendOver close...");
    }
}

