package com.lock.strategy.controller;

import com.lock.strategy.service.LockService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class LockController {

    @Resource
    private LockService lockService ;

    @RequestMapping("/getLock")
    public Boolean getLock () {
        // 锁定时间10S
        return lockService.getLock("lockKey","lockValue",10) ;
    }

    @RequestMapping("/updateByLock")
    public Boolean updateByLock () {
        Integer id = 1 ;
        Integer lockVersion = 1 ;
        return lockService.updateByLock(id,lockVersion) ;
    }

    @RequestMapping("/updateByInventory")
    public Boolean updateByInventory () {
        Integer id = 1 ;
        return lockService.updateByInventory(id) ;
    }
}
