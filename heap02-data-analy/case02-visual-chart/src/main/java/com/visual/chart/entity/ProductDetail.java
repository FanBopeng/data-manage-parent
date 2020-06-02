package com.visual.chart.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.util.Date;

@TableName("vc_product_detail")
public class ProductDetail {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品ID
     */
    private Integer productId;

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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
