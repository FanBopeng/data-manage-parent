package com.async.deal.service;

public interface RedisAsyncService {

    void sendMsg (String topic, String msg);

}
