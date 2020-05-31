package com.smart.tag.entity;

import java.util.List;

public class TagParam {

    private Integer dataType ;
    private String tagName ;
    private String bindColumn ;

    public TagParam() {
    }

    public TagParam(Integer dataType, String tagName, String bindColumn) {
        this.dataType = dataType;
        this.tagName = tagName;
        this.bindColumn = bindColumn;
    }

    private List<String> valueList ;

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getBindColumn() {
        return bindColumn;
    }

    public void setBindColumn(String bindColumn) {
        this.bindColumn = bindColumn;
    }

    public List<String> getValueList() {
        return valueList;
    }

    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }
}
