package com.dynamic.add.controller;

import com.dynamic.add.entity.ConnectionEntity;
import com.dynamic.add.service.ConnectionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@Api(value = "ConnectionController")
@RestController
public class ConnectionController {

    @Resource
    private ConnectionService connectionService ;

    @GetMapping("/testConnection")
    public boolean testConnection (ConnectionEntity connectionEntity){
        return connectionService.testConnection(connectionEntity) ;
    }

    @PostMapping("/addConnection")
    public boolean addConnection (ConnectionEntity connectionEntity){
        return connectionService.addConnection(connectionEntity) ;
    }
}
