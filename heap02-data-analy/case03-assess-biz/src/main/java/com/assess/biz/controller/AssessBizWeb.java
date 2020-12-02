package com.assess.biz.controller;

import com.assess.biz.entity.MatchItem;
import com.assess.biz.service.AssessBizService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 维度规则
 */
@RestController
public class AssessBizWeb {

    @Resource
    private AssessBizService assessBizService ;

    @GetMapping("/assessBiz")
    public String assessBiz (){
        MatchItem matchItem01 = new MatchItem("北京","新颖");
        MatchItem matchItem02 = new MatchItem("上海","清奇");
        assessBizService.assessBiz(matchItem01);
        assessBizService.assessBiz(matchItem02);
        return "SUS" ;
    }
}
