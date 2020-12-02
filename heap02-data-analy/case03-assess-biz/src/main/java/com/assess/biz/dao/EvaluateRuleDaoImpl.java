package com.assess.biz.dao;

import com.assess.biz.entity.EvaluateRuleEntity;
import com.assess.biz.mapper.EvaluateRuleMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EvaluateRuleDaoImpl extends ServiceImpl<EvaluateRuleMapper, EvaluateRuleEntity> implements EvaluateRuleDao {

    @Override
    public EvaluateRuleEntity getBySign(String classifySign,Integer ruleType) {
        return this.baseMapper.selectOne(new LambdaQueryWrapper<EvaluateRuleEntity>()
                                        .eq(EvaluateRuleEntity::getClassifySign,classifySign)
                                        .eq(EvaluateRuleEntity::getRuleType,ruleType));
    }
}
