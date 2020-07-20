package com.esearch.cluster.controller;

import com.esearch.cluster.entity.UserSearch;
import com.esearch.cluster.service.UserSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserSearchService userSearchService ;

    @GetMapping("/esInsert")
    public String esInsert() {
        return userSearchService.esInsert(3) ;
    }

    @GetMapping("/esFindAll")
    public Iterable<UserSearch> esFindAll () {
        return userSearchService.esFindAll() ;
    }

}
