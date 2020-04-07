package com.master.slave.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Aspect
@Component
@Order(1)
public class ReadWriteAop {

    private static Logger LOGGER = LoggerFactory.getLogger(ReadWriteAop.class) ;

    @Before("execution(* com.master.slave.controller.*.*(..))")
    public void setReadDataSourceType() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String method = request.getRequestURI() ;
        boolean rwFlag = readOrWrite(method) ;
        if (rwFlag){
            RouteContext.setRouteKey("slaveDataSource");
        } else {
            RouteContext.setRouteKey("masterDataSource");
        }
        LOGGER.info("请求方法:"+method+";执行库："+RouteContext.getRouteKey());
    }

    private String[] readArr = new String[]{"select","count","query","get","find"} ;
    private boolean readOrWrite (String method){
        for (String readVar:readArr) {
            if (method.contains(readVar)){
                return true ;
            }
        }
        return false ;
    }
}
