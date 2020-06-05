package com.async.deal.service.impl;

import com.async.deal.service.ReceiverService02;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ReceiverServiceImpl02 implements ReceiverService02 {

    private static final Logger LOGGER = LoggerFactory.getLogger("ReceiverMsg02");

    @Override
    public void receiverMsg(String msg) {
        LOGGER.info("Receiver02 收到消息：msg-{}",msg);
    }
}
