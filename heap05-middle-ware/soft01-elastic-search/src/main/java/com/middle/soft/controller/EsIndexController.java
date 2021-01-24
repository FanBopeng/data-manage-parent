package com.middle.soft.controller;

import com.middle.soft.constant.UserIndex;
import com.middle.soft.service.EsIndexOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EsIndexController {

    @Resource
    private EsIndexOperation esIndexOperation ;

    @GetMapping("/checkIndex")
    public boolean checkIndex (){
        return esIndexOperation.checkIndex(UserIndex.UserIndexV01);
    }

    @GetMapping("/createIndex")
    public boolean createIndex (){
        Map<String, Object> columnMap = new HashMap<>() ;
        // ID
        Map<String, Object> id = new HashMap<>();
        id.put("type", "integer");
        columnMap.put("id", id);
        // 姓名
        Map<String, Object> name = new HashMap<>();
        name.put("type", "keyword");
        columnMap.put("name", name);
        // 年龄
        Map<String, Object> age = new HashMap<>();
        age.put("type", "integer");
        columnMap.put("age", age);
        // 创建
        Map<String, Object> createTime = new HashMap<>();
        createTime.put("type", "long");
        columnMap.put("createTime", createTime);
        return esIndexOperation.createIndex(UserIndex.UserIndexV01, columnMap);
    }

    @GetMapping("/deleteIndex")
    public boolean deleteIndex (){
        return esIndexOperation.deleteIndex(UserIndex.UserIndexV01);
    }
}
