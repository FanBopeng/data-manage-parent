package com.zkper.cluster.controller;

import com.zkper.cluster.service.ZookeeperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class ZookeeperApi {

    @Resource
    private ZookeeperService zookeeperService ;

    @GetMapping("/isExistNode")
    public boolean isExistNode (final String path){
        return zookeeperService.isExistNode(path) ;
    }

    @GetMapping("/getNodeData")
    public String getNodeData (String path) {
        return zookeeperService.getNodeData(path) ;
    }

}