package com.kafka.cluster.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class SendStartInterceptor implements ProducerInterceptor<String, String> {

    private final Logger LOGGER = LoggerFactory.getLogger("SendStartInterceptor");
    @Override
    public void configure(Map<String, ?> configs) {
        LOGGER.info("configs...");
    }
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        // 修改消息内容
        return new ProducerRecord<>(record.topic(), record.partition(),
                                    record.timestamp(), record.key(),
                              "onSend：{" + record.value()+"}");
    }
    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        LOGGER.info("onAcknowledgement...");
    }
    @Override
    public void close() {
        LOGGER.info("SendStart close...");
    }
}
