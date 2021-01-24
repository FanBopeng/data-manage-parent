package com.middle.soft.controller;

import com.middle.soft.constant.UserIndex;
import com.middle.soft.service.EsDataOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EsDataController {

    @Resource
    private EsDataOperation esDataOperation ;

    @GetMapping("/insert")
    public boolean insert (){
        Map<String,Object> dataMap = new HashMap<>() ;
        dataMap.put("id", 1);
        dataMap.put("name", "上海-张三");
        dataMap.put("age", 12);
        dataMap.put("createTime", 1611378102795L);
        return esDataOperation.insert(UserIndex.UserIndexV01,dataMap) ;
    }

    @GetMapping("/batchInsert")
    public boolean batchInsert (){
        List<Map<String,Object>> userIndexList = new ArrayList<>() ;
        Map<String,Object> dataMap1 = new HashMap<>() ;
        dataMap1.put("id", 2);
        dataMap1.put("name", "北京-李四");
        dataMap1.put("age", 13);
        dataMap1.put("createTime", 1611378102795L);
        Map<String,Object> dataMap2 = new HashMap<>() ;
        dataMap2.put("id", 3);
        dataMap2.put("name", "深圳-王五");
        dataMap2.put("age", 18);
        dataMap2.put("createTime", System.currentTimeMillis());
        Map<String,Object> dataMap3 = new HashMap<>() ;
        dataMap3.put("id", 4);
        dataMap3.put("name", "杭州-赵六");
        dataMap3.put("age", 19);
        dataMap3.put("createTime", System.currentTimeMillis());
        userIndexList.add(dataMap1) ;
        userIndexList.add(dataMap2) ;
        userIndexList.add(dataMap3) ;
        return esDataOperation.batchInsert(UserIndex.UserIndexV01,userIndexList) ;
    }

    @GetMapping("/update")
    public boolean update (){
        Map<String,Object> dataMap = new HashMap<>() ;
        dataMap.put("id", 1);
        dataMap.put("age", 10);
        dataMap.put("updateTime", System.currentTimeMillis());
        return esDataOperation.update(UserIndex.UserIndexV01,dataMap) ;
    }

    @GetMapping("/delete")
    public boolean delete (){
        return esDataOperation.delete(UserIndex.UserIndexV01,"1") ;
    }

}
