package com.async.deal.config;

import com.async.deal.service.ReceiverService;
import com.async.deal.service.ReceiverService02;
import com.async.deal.service.impl.ReceiverServiceImpl;
import com.async.deal.service.impl.ReceiverServiceImpl02;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * Redis配置
 */
@Configuration
public class SubMsgConfig {

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory factory,
                                            MessageListenerAdapter msgListenerAdapter,
                                            MessageListenerAdapter msgListenerAdapter02){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        //注册多个监听,订阅一个主题，实现消息广播
        container.addMessageListener(msgListenerAdapter, new PatternTopic("topic:msg"));
        container.addMessageListener(msgListenerAdapter02, new PatternTopic("topic:msg"));
        return container;
    }

    @Bean
    MessageListenerAdapter msgListenerAdapter(ReceiverService receiverService){
        return new MessageListenerAdapter(receiverService, "receiverMsg");
    }
    @Bean
    MessageListenerAdapter msgListenerAdapter02(ReceiverService02 receiverService02){
        return new MessageListenerAdapter(receiverService02, "receiverMsg");
    }

    @Bean
    ReceiverService receiverService(){
        return new ReceiverServiceImpl();
    }
    @Bean
    ReceiverService02 receiverService02(){
        return new ReceiverServiceImpl02();
    }
}
