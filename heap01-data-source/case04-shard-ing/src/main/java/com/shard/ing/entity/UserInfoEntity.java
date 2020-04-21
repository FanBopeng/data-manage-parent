package com.shard.ing.entity;

public class UserInfoEntity {
    private Integer userId ;
    private String userPhone ;

    public UserInfoEntity() {
    }
    public UserInfoEntity(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
