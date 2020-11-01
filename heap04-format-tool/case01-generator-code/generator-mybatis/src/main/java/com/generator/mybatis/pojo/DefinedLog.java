package com.generator.mybatis.pojo;

public class DefinedLog {
    private Integer id;

    private String className;

    private String methodName;

    private String methodDesc;

    private Integer apiType;

    private Integer bizNature;

    private Integer dataFlowType;

    private String reqParam;

    private String resParam;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getMethodDesc() {
        return methodDesc;
    }

    public void setMethodDesc(String methodDesc) {
        this.methodDesc = methodDesc == null ? null : methodDesc.trim();
    }

    public Integer getApiType() {
        return apiType;
    }

    public void setApiType(Integer apiType) {
        this.apiType = apiType;
    }

    public Integer getBizNature() {
        return bizNature;
    }

    public void setBizNature(Integer bizNature) {
        this.bizNature = bizNature;
    }

    public Integer getDataFlowType() {
        return dataFlowType;
    }

    public void setDataFlowType(Integer dataFlowType) {
        this.dataFlowType = dataFlowType;
    }

    public String getReqParam() {
        return reqParam;
    }

    public void setReqParam(String reqParam) {
        this.reqParam = reqParam == null ? null : reqParam.trim();
    }

    public String getResParam() {
        return resParam;
    }

    public void setResParam(String resParam) {
        this.resParam = resParam == null ? null : resParam.trim();
    }
}