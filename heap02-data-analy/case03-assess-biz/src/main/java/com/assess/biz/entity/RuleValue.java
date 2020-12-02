package com.assess.biz.entity;

public class RuleValue {
    /**
     * 规则值描述
     */
    private Object ruleValue ;
    /**
     * 规则匹配结果
     */
    private Object ruleResult ;

    public RuleValue(Object ruleValue, Object ruleResult) {
        this.ruleValue = ruleValue;
        this.ruleResult = ruleResult;
    }

    public Object getRuleValue() {
        return ruleValue;
    }

    public void setRuleValue(Object ruleValue) {
        this.ruleValue = ruleValue;
    }

    public Object getRuleResult() {
        return ruleResult;
    }

    public void setRuleResult(Object ruleResult) {
        this.ruleResult = ruleResult;
    }
}
