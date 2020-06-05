package com.async.deal.controller;

import com.async.deal.util.HttpUtil;

public class RespTask implements Runnable {

    private String pageUrl ;

    public RespTask (String pageUrl){
        this.pageUrl = pageUrl ;
    }

    @Override
    public void run() {
        HttpUtil.get(pageUrl);
    }
}
