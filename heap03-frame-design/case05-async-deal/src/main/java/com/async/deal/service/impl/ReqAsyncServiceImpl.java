package com.async.deal.service.impl;

import com.async.deal.controller.RespTask;
import com.async.deal.service.ReqAsyncService;
import com.async.deal.util.HttpUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ReqAsyncServiceImpl implements ReqAsyncService {

    private static final String serverUrl = "http://localhost:8005" ;

    @Override
    public String tradeBegin(String param) {
        String orderNo = HttpUtil.get(serverUrl+"/respTrade?param="+param);
        if (StringUtils.isEmpty(orderNo)){
            return "Trade..Fail...";
        }
        return orderNo ;
    }

    @Override
    public void respTrade(String param) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread01 = new Thread(
                new RespTask(serverUrl+"/tradeSucNotify?param="+param),"SucNotify");
        Thread thread02 = new Thread(
                new RespTask(serverUrl+"/tradeFailNotify?param="+param),"FailNotify");
        thread01.start();
        thread02.start();
    }

}
