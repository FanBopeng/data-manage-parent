package com.visual.chart.controller;

import com.visual.chart.entity.DataSetEntity;
import com.visual.chart.service.DataSetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DataSetController {

    @Resource
    private DataSetService dataSetService ;

    @GetMapping("/findAll")
    public List<DataSetEntity> findAll (){
        return dataSetService.findAll() ;
    }
}
