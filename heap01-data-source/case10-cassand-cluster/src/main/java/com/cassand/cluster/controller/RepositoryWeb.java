package com.cassand.cluster.controller;

import com.cassand.cluster.entity.UserInfo;
import com.cassand.cluster.service.RepositoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RepositoryWeb {

    @Resource
    private RepositoryService repositoryService ;

    @GetMapping("/repository/save")
    public UserInfo save (){
        UserInfo userInfo = new UserInfo(5,"王五") ;
        return repositoryService.save(userInfo) ;
    }

    @GetMapping("/repository/getById")
    public UserInfo getById (Integer id){
        return repositoryService.getById(id) ;
    }

    @GetMapping("/repository/update")
    public UserInfo update (){
        UserInfo userInfo = new UserInfo(5,"王六") ;
        return repositoryService.update(userInfo);
    }

    @GetMapping("/repository/deleteById")
    public String deleteById (Integer id){
        repositoryService.deleteById(id);
        return "sign" ;
    }
}
