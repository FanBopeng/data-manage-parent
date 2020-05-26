package com.idem.potent.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("dp_order_state")
public class OrderState {

    private Long orderId ;
    private String tokenId ;
    private Integer state ;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
