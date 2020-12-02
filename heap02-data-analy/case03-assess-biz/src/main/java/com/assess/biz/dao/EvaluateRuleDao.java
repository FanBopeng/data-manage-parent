package com.assess.biz.dao;

import com.assess.biz.entity.EvaluateRuleEntity;
import com.baomidou.mybatisplus.extension.service.IService;

public interface EvaluateRuleDao extends IService<EvaluateRuleEntity> {
    EvaluateRuleEntity getBySign (String classifySign,Integer ruleType);
}
