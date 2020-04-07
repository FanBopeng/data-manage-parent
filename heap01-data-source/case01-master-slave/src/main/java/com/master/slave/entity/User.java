package com.master.slave.entity;

public class User {
    private Integer id ;
    private String userName ;
    private String dataSign ;

    public User() {
        super();
    }

    public User(String userName, String dataSign) {
        this.userName = userName;
        this.dataSign = dataSign;
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

    public String getDataSign() {
        return dataSign;
    }

    public void setDataSign(String dataSign) {
        this.dataSign = dataSign;
    }
}
