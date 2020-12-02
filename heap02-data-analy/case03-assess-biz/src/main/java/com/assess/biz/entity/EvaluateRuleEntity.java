package com.assess.biz.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("evaluate_rule")
public class EvaluateRuleEntity {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 归类标识
     */
    private String classifySign;
    /**
     * 规则描述
     */
    private String ruleValue;
    /**
     * 规则类型：1精准匹配，2范围，3模糊
     */
    private Integer ruleType;
    /**
     * 权重分布
     */
    private float weight ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassifySign() {
        return classifySign;
    }

    public void setClassifySign(String classifySign) {
        this.classifySign = classifySign;
    }

    public String getRuleValue() {
        return ruleValue;
    }

    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue;
    }

    public Integer getRuleType() {
        return ruleType;
    }

    public void setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
