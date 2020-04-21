package com.shard.ing.controller;

import com.shard.ing.entity.UserInfoEntity;
import com.shard.ing.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ShardController {

    @Resource
    private UserInfoService userInfoService ;

    @GetMapping("/batchInsert")
    public String batchInsert(){
        List<UserInfoEntity> userList = new ArrayList<>() ;
        userList.add(new UserInfoEntity("18978361211"));
        userList.add(new UserInfoEntity("18978361212"));
        userList.add(new UserInfoEntity("18978361213"));
        userList.add(new UserInfoEntity("18978361214"));
        userList.add(new UserInfoEntity("18978361215"));
        userList.add(new UserInfoEntity("18978361216"));
        userList.add(new UserInfoEntity("18978361217"));
        userList.add(new UserInfoEntity("18978361218"));
        userList.add(new UserInfoEntity("18978361219"));
        userList.add(new UserInfoEntity("18978361221"));
        userList.add(new UserInfoEntity("18978361222"));
        userList.add(new UserInfoEntity("18978361233"));
        userList.add(new UserInfoEntity("18978361244"));
        userList.add(new UserInfoEntity("18978361255"));
        userList.add(new UserInfoEntity("18978361266"));
        userList.add(new UserInfoEntity("18978361277"));
        userList.add(new UserInfoEntity("18978361288"));
        userList.add(new UserInfoEntity("18978361299"));
        userList.add(new UserInfoEntity("18978361231"));
        userList.add(new UserInfoEntity("18978361232"));
        userList.add(new UserInfoEntity("18978361235"));
        userList.add(new UserInfoEntity("18978361236"));
        userInfoService.batchInsert(userList);
        return "success" ;
    }

    @GetMapping("/selectByPhone")
    public UserInfoEntity selectByPhone (){
        return userInfoService.selectByPhone("18978361236") ;
    }

}
