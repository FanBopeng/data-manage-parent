package com.generator.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class DefinedLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DefinedLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andMethodNameIsNull() {
            addCriterion("method_name is null");
            return (Criteria) this;
        }

        public Criteria andMethodNameIsNotNull() {
            addCriterion("method_name is not null");
            return (Criteria) this;
        }

        public Criteria andMethodNameEqualTo(String value) {
            addCriterion("method_name =", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotEqualTo(String value) {
            addCriterion("method_name <>", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameGreaterThan(String value) {
            addCriterion("method_name >", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameGreaterThanOrEqualTo(String value) {
            addCriterion("method_name >=", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLessThan(String value) {
            addCriterion("method_name <", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLessThanOrEqualTo(String value) {
            addCriterion("method_name <=", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLike(String value) {
            addCriterion("method_name like", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotLike(String value) {
            addCriterion("method_name not like", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameIn(List<String> values) {
            addCriterion("method_name in", values, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotIn(List<String> values) {
            addCriterion("method_name not in", values, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameBetween(String value1, String value2) {
            addCriterion("method_name between", value1, value2, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotBetween(String value1, String value2) {
            addCriterion("method_name not between", value1, value2, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodDescIsNull() {
            addCriterion("method_desc is null");
            return (Criteria) this;
        }

        public Criteria andMethodDescIsNotNull() {
            addCriterion("method_desc is not null");
            return (Criteria) this;
        }

        public Criteria andMethodDescEqualTo(String value) {
            addCriterion("method_desc =", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescNotEqualTo(String value) {
            addCriterion("method_desc <>", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescGreaterThan(String value) {
            addCriterion("method_desc >", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescGreaterThanOrEqualTo(String value) {
            addCriterion("method_desc >=", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescLessThan(String value) {
            addCriterion("method_desc <", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescLessThanOrEqualTo(String value) {
            addCriterion("method_desc <=", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescLike(String value) {
            addCriterion("method_desc like", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescNotLike(String value) {
            addCriterion("method_desc not like", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescIn(List<String> values) {
            addCriterion("method_desc in", values, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescNotIn(List<String> values) {
            addCriterion("method_desc not in", values, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescBetween(String value1, String value2) {
            addCriterion("method_desc between", value1, value2, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescNotBetween(String value1, String value2) {
            addCriterion("method_desc not between", value1, value2, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andApiTypeIsNull() {
            addCriterion("api_type is null");
            return (Criteria) this;
        }

        public Criteria andApiTypeIsNotNull() {
            addCriterion("api_type is not null");
            return (Criteria) this;
        }

        public Criteria andApiTypeEqualTo(Integer value) {
            addCriterion("api_type =", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeNotEqualTo(Integer value) {
            addCriterion("api_type <>", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeGreaterThan(Integer value) {
            addCriterion("api_type >", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("api_type >=", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeLessThan(Integer value) {
            addCriterion("api_type <", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeLessThanOrEqualTo(Integer value) {
            addCriterion("api_type <=", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeIn(List<Integer> values) {
            addCriterion("api_type in", values, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeNotIn(List<Integer> values) {
            addCriterion("api_type not in", values, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeBetween(Integer value1, Integer value2) {
            addCriterion("api_type between", value1, value2, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("api_type not between", value1, value2, "apiType");
            return (Criteria) this;
        }

        public Criteria andBizNatureIsNull() {
            addCriterion("biz_nature is null");
            return (Criteria) this;
        }

        public Criteria andBizNatureIsNotNull() {
            addCriterion("biz_nature is not null");
            return (Criteria) this;
        }

        public Criteria andBizNatureEqualTo(Integer value) {
            addCriterion("biz_nature =", value, "bizNature");
            return (Criteria) this;
        }

        public Criteria andBizNatureNotEqualTo(Integer value) {
            addCriterion("biz_nature <>", value, "bizNature");
            return (Criteria) this;
        }

        public Criteria andBizNatureGreaterThan(Integer value) {
            addCriterion("biz_nature >", value, "bizNature");
            return (Criteria) this;
        }

        public Criteria andBizNatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("biz_nature >=", value, "bizNature");
            return (Criteria) this;
        }

        public Criteria andBizNatureLessThan(Integer value) {
            addCriterion("biz_nature <", value, "bizNature");
            return (Criteria) this;
        }

        public Criteria andBizNatureLessThanOrEqualTo(Integer value) {
            addCriterion("biz_nature <=", value, "bizNature");
            return (Criteria) this;
        }

        public Criteria andBizNatureIn(List<Integer> values) {
            addCriterion("biz_nature in", values, "bizNature");
            return (Criteria) this;
        }

        public Criteria andBizNatureNotIn(List<Integer> values) {
            addCriterion("biz_nature not in", values, "bizNature");
            return (Criteria) this;
        }

        public Criteria andBizNatureBetween(Integer value1, Integer value2) {
            addCriterion("biz_nature between", value1, value2, "bizNature");
            return (Criteria) this;
        }

        public Criteria andBizNatureNotBetween(Integer value1, Integer value2) {
            addCriterion("biz_nature not between", value1, value2, "bizNature");
            return (Criteria) this;
        }

        public Criteria andDataFlowTypeIsNull() {
            addCriterion("data_flow_type is null");
            return (Criteria) this;
        }

        public Criteria andDataFlowTypeIsNotNull() {
            addCriterion("data_flow_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataFlowTypeEqualTo(Integer value) {
            addCriterion("data_flow_type =", value, "dataFlowType");
            return (Criteria) this;
        }

        public Criteria andDataFlowTypeNotEqualTo(Integer value) {
            addCriterion("data_flow_type <>", value, "dataFlowType");
            return (Criteria) this;
        }

        public Criteria andDataFlowTypeGreaterThan(Integer value) {
            addCriterion("data_flow_type >", value, "dataFlowType");
            return (Criteria) this;
        }

        public Criteria andDataFlowTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_flow_type >=", value, "dataFlowType");
            return (Criteria) this;
        }

        public Criteria andDataFlowTypeLessThan(Integer value) {
            addCriterion("data_flow_type <", value, "dataFlowType");
            return (Criteria) this;
        }

        public Criteria andDataFlowTypeLessThanOrEqualTo(Integer value) {
            addCriterion("data_flow_type <=", value, "dataFlowType");
            return (Criteria) this;
        }

        public Criteria andDataFlowTypeIn(List<Integer> values) {
            addCriterion("data_flow_type in", values, "dataFlowType");
            return (Criteria) this;
        }

        public Criteria andDataFlowTypeNotIn(List<Integer> values) {
            addCriterion("data_flow_type not in", values, "dataFlowType");
            return (Criteria) this;
        }

        public Criteria andDataFlowTypeBetween(Integer value1, Integer value2) {
            addCriterion("data_flow_type between", value1, value2, "dataFlowType");
            return (Criteria) this;
        }

        public Criteria andDataFlowTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("data_flow_type not between", value1, value2, "dataFlowType");
            return (Criteria) this;
        }

        public Criteria andReqParamIsNull() {
            addCriterion("req_param is null");
            return (Criteria) this;
        }

        public Criteria andReqParamIsNotNull() {
            addCriterion("req_param is not null");
            return (Criteria) this;
        }

        public Criteria andReqParamEqualTo(String value) {
            addCriterion("req_param =", value, "reqParam");
            return (Criteria) this;
        }

        public Criteria andReqParamNotEqualTo(String value) {
            addCriterion("req_param <>", value, "reqParam");
            return (Criteria) this;
        }

        public Criteria andReqParamGreaterThan(String value) {
            addCriterion("req_param >", value, "reqParam");
            return (Criteria) this;
        }

        public Criteria andReqParamGreaterThanOrEqualTo(String value) {
            addCriterion("req_param >=", value, "reqParam");
            return (Criteria) this;
        }

        public Criteria andReqParamLessThan(String value) {
            addCriterion("req_param <", value, "reqParam");
            return (Criteria) this;
        }

        public Criteria andReqParamLessThanOrEqualTo(String value) {
            addCriterion("req_param <=", value, "reqParam");
            return (Criteria) this;
        }

        public Criteria andReqParamLike(String value) {
            addCriterion("req_param like", value, "reqParam");
            return (Criteria) this;
        }

        public Criteria andReqParamNotLike(String value) {
            addCriterion("req_param not like", value, "reqParam");
            return (Criteria) this;
        }

        public Criteria andReqParamIn(List<String> values) {
            addCriterion("req_param in", values, "reqParam");
            return (Criteria) this;
        }

        public Criteria andReqParamNotIn(List<String> values) {
            addCriterion("req_param not in", values, "reqParam");
            return (Criteria) this;
        }

        public Criteria andReqParamBetween(String value1, String value2) {
            addCriterion("req_param between", value1, value2, "reqParam");
            return (Criteria) this;
        }

        public Criteria andReqParamNotBetween(String value1, String value2) {
            addCriterion("req_param not between", value1, value2, "reqParam");
            return (Criteria) this;
        }

        public Criteria andResParamIsNull() {
            addCriterion("res_param is null");
            return (Criteria) this;
        }

        public Criteria andResParamIsNotNull() {
            addCriterion("res_param is not null");
            return (Criteria) this;
        }

        public Criteria andResParamEqualTo(String value) {
            addCriterion("res_param =", value, "resParam");
            return (Criteria) this;
        }

        public Criteria andResParamNotEqualTo(String value) {
            addCriterion("res_param <>", value, "resParam");
            return (Criteria) this;
        }

        public Criteria andResParamGreaterThan(String value) {
            addCriterion("res_param >", value, "resParam");
            return (Criteria) this;
        }

        public Criteria andResParamGreaterThanOrEqualTo(String value) {
            addCriterion("res_param >=", value, "resParam");
            return (Criteria) this;
        }

        public Criteria andResParamLessThan(String value) {
            addCriterion("res_param <", value, "resParam");
            return (Criteria) this;
        }

        public Criteria andResParamLessThanOrEqualTo(String value) {
            addCriterion("res_param <=", value, "resParam");
            return (Criteria) this;
        }

        public Criteria andResParamLike(String value) {
            addCriterion("res_param like", value, "resParam");
            return (Criteria) this;
        }

        public Criteria andResParamNotLike(String value) {
            addCriterion("res_param not like", value, "resParam");
            return (Criteria) this;
        }

        public Criteria andResParamIn(List<String> values) {
            addCriterion("res_param in", values, "resParam");
            return (Criteria) this;
        }

        public Criteria andResParamNotIn(List<String> values) {
            addCriterion("res_param not in", values, "resParam");
            return (Criteria) this;
        }

        public Criteria andResParamBetween(String value1, String value2) {
            addCriterion("res_param between", value1, value2, "resParam");
            return (Criteria) this;
        }

        public Criteria andResParamNotBetween(String value1, String value2) {
            addCriterion("res_param not between", value1, value2, "resParam");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}