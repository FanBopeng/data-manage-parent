package com.assess.biz.controller;

import com.alibaba.fastjson.JSONObject;
import com.assess.biz.dao.EvaluateRuleDao;
import com.assess.biz.entity.EvaluateRuleEntity;
import com.assess.biz.entity.RuleValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 维度规则
 */
@RestController
public class EvaluateRuleWeb {

    @Resource
    private EvaluateRuleDao evaluateRuleDao ;

    @GetMapping("/batchSave")
    public String batchSave (){

        List<EvaluateRuleEntity> dataList = new ArrayList<>() ;

        EvaluateRuleEntity evaluateRule01 = new EvaluateRuleEntity() ;
        evaluateRule01.setClassifySign("assess-biz");

        RuleValue ruleValue01 = new RuleValue("北京",100);
        RuleValue ruleValue02 = new RuleValue("上海",50);
        List<RuleValue> ruleValueList01 = new ArrayList<>();
        ruleValueList01.add(ruleValue01);
        ruleValueList01.add(ruleValue02);

        evaluateRule01.setRuleValue(JSONObject.toJSONString(ruleValueList01));
        evaluateRule01.setWeight(0.5f);
        evaluateRule01.setRuleType(1);

        EvaluateRuleEntity evaluateRule02 = new EvaluateRuleEntity() ;
        evaluateRule02.setClassifySign("assess-biz");

        RuleValue ruleValue03 = new RuleValue("想法清奇",400);
        RuleValue ruleValue04 = new RuleValue("创意新颖",200);
        List<RuleValue> ruleValueList02 = new ArrayList<>();
        ruleValueList02.add(ruleValue03);
        ruleValueList02.add(ruleValue04);

        evaluateRule02.setRuleValue(JSONObject.toJSONString(ruleValueList02));
        evaluateRule02.setWeight(0.5f);
        evaluateRule02.setRuleType(3);

        dataList.add(evaluateRule01);
        dataList.add(evaluateRule02);

        evaluateRuleDao.saveBatch(dataList);

        return "SUS" ;
    }
}
