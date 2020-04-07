package com.master.slave.controller;

import com.master.slave.entity.User;
import com.master.slave.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService ;

    @GetMapping("/selectById")
    public User selectById (@RequestParam("id") Integer id) {
        return userService.selectById(id) ;
    }

    @GetMapping("/insert")
    public String insert () {
        User user = new User("张三","write") ;
        userService.insert(user) ;
        return "success" ;
    }
}
