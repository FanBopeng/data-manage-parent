package com.visual.chart.controller;

import com.visual.chart.service.ProductInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ChartController {

    @Resource
    private ProductInfoService productInfoService ;

    @GetMapping("/getData")
    public Map<String,Object> getData (){
        Map<String,Object> dataMap = new HashMap<>() ;
        dataMap.put("countNum",productInfoService.countNum());
        dataMap.put("sumAll",productInfoService.sumAll());
        dataMap.put("groupSum",productInfoService.groupSum());
        dataMap.put("average",productInfoService.average());
        return dataMap ;
    }
}
