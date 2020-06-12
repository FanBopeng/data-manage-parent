package com.kafka.cluster.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Configuration
public class KafkaConfig {

    @Bean
    public Producer producer (){
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.72.133:9092");
        props.put("acks", "all");
        props.put("retries", 1);
        props.put("batch.size", 16384);
        // 等待时间
        props.put("linger.ms", 1);
        // RecordAccumulator缓冲区大小
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 添加拦截器
        List<String> interceptors = new ArrayList<>();
        interceptors.add("com.kafka.cluster.interceptor.SendStartInterceptor");
        interceptors.add("com.kafka.cluster.interceptor.SendOverInterceptor");
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);
        return new KafkaProducer<>(props) ;
    }

}
