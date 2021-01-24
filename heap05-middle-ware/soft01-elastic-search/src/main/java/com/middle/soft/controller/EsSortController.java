package com.middle.soft.controller;

import com.middle.soft.constant.UserIndex;
import com.middle.soft.service.EsSortOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class EsSortController {

    @Resource
    private EsSortOperation esSortOperation ;

    @GetMapping("/sort")
    public List<Map<String,Object>> sort (){
        return esSortOperation.sort(UserIndex.UserIndexV01) ;
    }

    @GetMapping("/defSort")
    public List<Map<String,Object>> defSort (){
        return esSortOperation.defSort(UserIndex.UserIndexV01) ;
    }
}
