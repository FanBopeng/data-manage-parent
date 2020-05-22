package com.ckhouse.cluster.controller;

import com.ckhouse.cluster.entity.DataAllEntity;
import com.ckhouse.cluster.service.DataAllService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class DaraAllWeb {

    @Resource
    private DataAllService dataAllService ;

    @GetMapping("/getList")
    public List<DataAllEntity> getList (){
        return dataAllService.getList() ;
    }
}
