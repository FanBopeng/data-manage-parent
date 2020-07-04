package com.service.data.controller;

import com.service.data.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AccountController {

    @Resource
    private AccountService accountService ;

    @GetMapping("/transfer")
    public String transfer (){
        accountService.transfer("jack","tom",1000);
        return "sus" ;
    }
}
