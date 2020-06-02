package com.visual.chart.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

@TableName("data_set_view")
public class DataSetEntity {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 产品分类
     */
    private String productSort;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 库存剩余
     */
    private Integer inventory;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 销售总量
     */
    private Integer totalSales;

    /**
     * 销售总额
     */
    private BigDecimal salesAmount;

    /**
     * 产品产地
     */
    private String placeOrigin;

    /**
     * 重量
     */
    private BigDecimal weight;

    /**
     * 颜色
     */
    private String color;

    /**
     * 好评数量
     */
    private Integer highPraise;

    /**
     * 差评数量
     */
    private Integer lowPraise;

    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductSort() {
        return productSort;
    }

    public void setProductSort(String productSort) {
        this.productSort = productSort;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    public BigDecimal getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getHighPraise() {
        return highPraise;
    }

    public void setHighPraise(Integer highPraise) {
        this.highPraise = highPraise;
    }

    public Integer getLowPraise() {
        return lowPraise;
    }

    public void setLowPraise(Integer lowPraise) {
        this.lowPraise = lowPraise;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
