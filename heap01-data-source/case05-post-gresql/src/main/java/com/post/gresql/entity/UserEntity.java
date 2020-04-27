package com.post.gresql.entity;
import java.util.Date;

public class UserEntity {
    private Integer id ;
    private String userName ;
    private Integer userAge ;
    private Date createTime ;

    public UserEntity (){}

    public UserEntity(Integer id, String userName, Integer userAge, Date createTime) {
        this.id = id;
        this.userName = userName;
        this.userAge = userAge;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Integer getUserAge() {
        return userAge;
    }
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
