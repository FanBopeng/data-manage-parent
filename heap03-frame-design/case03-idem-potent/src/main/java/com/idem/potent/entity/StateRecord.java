package com.idem.potent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("dp_state_record")
public class StateRecord {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id ;
    private Long orderId ;
    private String stateDec ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStateDec() {
        return stateDec;
    }

    public void setStateDec(String stateDec) {
        this.stateDec = stateDec;
    }
}
