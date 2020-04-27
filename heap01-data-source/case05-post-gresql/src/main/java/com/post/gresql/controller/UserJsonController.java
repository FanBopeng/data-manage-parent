package com.post.gresql.controller;

import com.alibaba.fastjson.JSON;
import com.post.gresql.entity.UserEntity;
import com.post.gresql.entity.UserJsonEntity;
import com.post.gresql.service.UserJsonService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(value = "UserJsonController")
@RestController
public class UserJsonController {

    @Resource
    private UserJsonService userJsonService ;

    @GetMapping("/addUserJson")
    public boolean addUserJson (){
        List<UserEntity> userEntities = new ArrayList<>() ;
        UserEntity userEntity1 = new UserEntity(1,"LiSi",22,new Date());
        UserEntity userEntity2 = new UserEntity(2,"WangWu",23,new Date());
        userEntities.add(userEntity1);
        userEntities.add(userEntity2);
        UserJsonEntity userJsonEntity = new UserJsonEntity();
        userJsonEntity.setId(1);
        userJsonEntity.setTitle("第一批名单");
        userJsonEntity.setUserList(JSON.toJSONString(userEntities));
        userJsonEntity.setCreateTime(new Date());
        return userJsonService.addUserJson(userJsonEntity) ;
    }

    @GetMapping("/findUserJson")
    public List<UserEntity> findUserJson (@RequestParam("id") Integer id){
        UserJsonEntity userJsonEntity = userJsonService.findUserJson(id) ;
        return JSON.parseArray(userJsonEntity.getUserList(),UserEntity.class) ;
    }

}
