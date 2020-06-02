package com.visual.chart.controller;

import com.visual.chart.entity.ChartParam;
import com.visual.chart.service.DataSetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class DefineController {

    @Resource
    private DataSetService dataSetService ;
    /**
     * 自定义可视化报告
     */
    @GetMapping("/getDefChart")
    public Map<Integer, List<ChartParam>> getDefChart (){
        List<ChartParam> chartParamList = new ArrayList<>() ;
        chartParamList.add(new ChartParam("X",1,"data_set_view","product_sort")) ;
        chartParamList.add(new ChartParam("X",1,"data_set_view","product_name")) ;
        chartParamList.add(new ChartParam("Y",2,"data_set_view","high_praise")) ;
        chartParamList.add(new ChartParam("Y",2,"data_set_view","low_praise")) ;
        chartParamList.add(new ChartParam("Z",3,"data_set_view","inventory",1)) ;
        chartParamList.add(new ChartParam("Z",3,"data_set_view","total_sales",1)) ;
        return dataSetService.analyData(chartParamList);
    }
}
