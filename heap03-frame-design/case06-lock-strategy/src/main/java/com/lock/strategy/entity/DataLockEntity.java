package com.lock.strategy.entity;

public class DataLockEntity {
    private Integer id ;
    private Integer inventory ;
    private Integer lockValue ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getLockValue() {
        return lockValue;
    }

    public void setLockValue(Integer lockValue) {
        this.lockValue = lockValue;
    }
}
