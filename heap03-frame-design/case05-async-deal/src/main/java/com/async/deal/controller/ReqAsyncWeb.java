package com.async.deal.controller;

import com.async.deal.service.ReqAsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * 接口请求模式下异步处理
 */
@RestController
public class ReqAsyncWeb {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReqAsyncWeb.class);

    @Resource
    private ReqAsyncService reqAsyncService ;

    // 本地交易接口
    @GetMapping("/tradeBegin")
    public String tradeBegin (){
        String sign = reqAsyncService.tradeBegin("TradeClient");
        return sign ;
    }

    // 交易成功通知接口
    @GetMapping("/tradeSucNotify")
    public String tradeSucNotify (@RequestParam("param") String param){
        LOGGER.info("tradeSucNotify param={"+ param +"}");
        return "success" ;
    }

    // 交易失败通知接口
    @GetMapping("/tradeFailNotify")
    public String tradeFailNotify (@RequestParam("param") String param){
        LOGGER.info("tradeFailNotify param={"+ param +"}");
        return "success" ;
    }

    // 第三方交易接口
    @GetMapping("/respTrade")
    public String respTrade (@RequestParam("param") String param){
        LOGGER.info("respTrade param={"+ param +"}");
        reqAsyncService.respTrade(param);
        return "NO20200520" ;
    }

}
