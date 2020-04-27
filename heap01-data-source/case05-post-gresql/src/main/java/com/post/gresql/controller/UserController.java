package com.post.gresql.controller;

import com.github.pagehelper.PageInfo;
import com.post.gresql.entity.UserEntity;
import com.post.gresql.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@Api(value = "UserController")
@RestController
public class UserController {

    @Resource
    private UserService userService ;

    @GetMapping("/selectById")
    public UserEntity selectById (Integer id){
        return userService.selectById(id) ;
    }

    @PostMapping("/insert")
    public Integer insert (UserEntity userEntity){
        return userService.insert(userEntity) ;
    }

    @GetMapping("/pageQuery")
    public PageInfo<UserEntity> pageQuery (@RequestParam("page") int page){
        int pageSize = 3 ;
        return userService.pageQuery(page,pageSize) ;
    }
}
