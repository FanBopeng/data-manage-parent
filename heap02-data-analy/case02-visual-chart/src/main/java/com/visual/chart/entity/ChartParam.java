package com.visual.chart.entity;

public class ChartParam {

    public ChartParam(String axis, Integer dataType, String tableName, String columnName) {
        this.axis = axis;
        this.dataType = dataType;
        this.tableName = tableName;
        this.columnName = columnName;
    }

    public ChartParam(String axis, Integer dataType, String tableName, String columnName,Integer productId) {
        this.axis = axis;
        this.dataType = dataType;
        this.tableName = tableName;
        this.columnName = columnName;
        this.productId = productId;
    }

    // 轴：X、Y、Z
    private String axis ;
    // 类型：1 Count、2 Sum、3 Percent
    private Integer dataType ;
    // 查询表
    private String tableName ;
    // 计算字段
    private String columnName ;
    // 核心产品ID
    private Integer productId ;
    // 结果值
    private Double resultNum ;

    public String getAxis() {
        return axis;
    }

    public void setAxis(String axis) {
        this.axis = axis;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getResultNum() {
        return resultNum;
    }

    public void setResultNum(Double resultNum) {
        this.resultNum = resultNum;
    }
}
