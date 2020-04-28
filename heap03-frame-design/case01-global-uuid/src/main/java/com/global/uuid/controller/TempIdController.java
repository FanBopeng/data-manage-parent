package com.global.uuid.controller;

import com.global.uuid.service.TempIdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class TempIdController {

    @Resource
    private TempIdService tempIdService ;

    /*
     * "UID00011","UID00012","UID00013","UID00014","UID00015"
     * "UID00016","UID00017","UID00018","UID00019","UID00020"
     */
    @GetMapping("/getIdList")
    public List<String> getIdList (){
        return tempIdService.getIdList() ;
    }

    /*
     * "UID-A00001","UID-B00001","UID-C00001"
     * "UID-A00002","UID-B00002","UID-C00002"
     */
    @GetMapping("/getRouteIdList")
    public List<String> getRouteIdList() {
        return tempIdService.getRouteIdList();
    }
}
