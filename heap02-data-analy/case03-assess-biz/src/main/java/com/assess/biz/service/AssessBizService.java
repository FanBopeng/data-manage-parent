package com.assess.biz.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.assess.biz.dao.EvaluateRuleDao;
import com.assess.biz.entity.EvaluateRuleEntity;
import com.assess.biz.entity.MatchItem;
import com.assess.biz.entity.RuleValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class AssessBizService {

    private static Logger LOG = LoggerFactory.getLogger(AssessBizService.class);

    @Resource
    private EvaluateRuleDao evaluateRuleDao ;

    /**
     * 业务评估流程
     */
    public void assessBiz (MatchItem matchItem){
        // 精准匹配城市
        EvaluateRuleEntity evaluateRule01 = evaluateRuleDao.getBySign("assess-biz",1);
        List<RuleValue> cityRuleList = JSONArray.parseArray(evaluateRule01.getRuleValue(), RuleValue.class);
        for (RuleValue cityRule:cityRuleList){
            if (cityRule.getRuleValue().equals(matchItem.getCity())){
                int result = Integer.parseInt(String.valueOf(cityRule.getRuleResult()));
                LOG.info("匹配项:{},匹配结果:{}",matchItem.getCity(),result*evaluateRule01.getWeight());
                break ;
            }
        }
        // 模糊匹配标签
        EvaluateRuleEntity evaluateRule02 = evaluateRuleDao.getBySign("assess-biz",3);
        List<RuleValue> tagRuleList = JSONArray.parseArray(evaluateRule02.getRuleValue(), RuleValue.class);
        for (RuleValue tagRule:tagRuleList){
            if (String.valueOf(tagRule.getRuleValue()).contains(matchItem.getTag())){
                int result = Integer.parseInt(String.valueOf(tagRule.getRuleResult()));
                LOG.info("匹配项:{},匹配结果:{}",matchItem.getTag(),result*evaluateRule02.getWeight());
                break ;
            }
        }
    }

}
