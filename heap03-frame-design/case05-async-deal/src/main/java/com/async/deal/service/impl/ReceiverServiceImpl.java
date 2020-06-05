package com.async.deal.service.impl;

import com.async.deal.service.ReceiverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ReceiverServiceImpl implements ReceiverService {

    private static final Logger LOGGER = LoggerFactory.getLogger("ReceiverMsg");

    @Override
    public void receiverMsg(String msg) {
        LOGGER.info("Receiver01 收到消息：msg-{}",msg);
    }
}
