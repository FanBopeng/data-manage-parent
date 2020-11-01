package com.generator.mybatis.plugin.entity;

import java.io.Serializable;

/**
 * 日志记录表(DtDefinedLog)实体类
 *
 * @author makejava
 * @since 2020-11-01 00:04:53
 */
public class DtDefinedLog implements Serializable {
    private static final long serialVersionUID = 296482753255875084L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 请求类名
    */
    private String className;
    /**
    * 请求方法名
    */
    private String methodName;
    /**
    * 请求方法描述
    */
    private String methodDesc;
    /**
    * API类型
    */
    private Integer apiType;
    /**
    * 业务性质类型
    */
    private Integer bizNature;
    /**
    * 日志数据流向
    */
    private Integer dataFlowType;
    /**
    * 请求报文
    */
    private String reqParam;
    /**
    * 响应报文
    */
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
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodDesc() {
        return methodDesc;
    }

    public void setMethodDesc(String methodDesc) {
        this.methodDesc = methodDesc;
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
        this.reqParam = reqParam;
    }

    public String getResParam() {
        return resParam;
    }

    public void setResParam(String resParam) {
        this.resParam = resParam;
    }

}