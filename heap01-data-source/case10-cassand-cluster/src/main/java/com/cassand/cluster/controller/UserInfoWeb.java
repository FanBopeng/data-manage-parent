package com.cassand.cluster.controller;

import com.cassand.cluster.entity.UserInfo;
import com.cassand.cluster.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserInfoWeb {

    @Resource
    private UserInfoService userInfoService ;

    @GetMapping("/getList")
    public List<UserInfo> getList (){
        return userInfoService.getList() ;
    }

    @GetMapping("/insert")
    public UserInfo insert (){
        UserInfo userInfo1 = new UserInfo(2,"say") ;
        UserInfo userInfo2 = new UserInfo(3,"hello") ;
        userInfoService.insert(userInfo1) ;
        return userInfoService.insert(userInfo2) ;
    }

    @GetMapping("/selectOneById")
    public UserInfo selectOneById (Integer id){
        return userInfoService.selectOneById(id) ;
    }

    @GetMapping("/update")
    public UserInfo update (){
        UserInfo userInfo = new UserInfo(3,"world") ;
        return userInfoService.update(userInfo) ;
    }

    @GetMapping("/deleteById")
    public Boolean deleteById (Integer id){
        return userInfoService.deleteById(id) ;
    }
}
