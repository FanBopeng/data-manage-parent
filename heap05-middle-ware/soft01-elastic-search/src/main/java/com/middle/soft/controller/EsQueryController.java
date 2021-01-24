package com.middle.soft.controller;

import com.middle.soft.constant.UserIndex;
import com.middle.soft.service.EsQueryOperation;
import org.elasticsearch.search.SearchHit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class EsQueryController {

    @Resource
    private EsQueryOperation esQueryOperation ;

    @GetMapping("/count")
    public Long count (){
        return esQueryOperation.count(UserIndex.UserIndexV01) ;
    }

    @GetMapping("/list")
    public List<Map<String,Object>> list (){
        return esQueryOperation.list(UserIndex.UserIndexV01) ;
    }

    @GetMapping("/page")
    public List<Map<String,Object>> page (){
        return esQueryOperation.page(UserIndex.UserIndexV01,1,2) ;
    }
}
