package com.cassand.cluster.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("user_info")
public class UserInfo {

    public UserInfo(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    @PrimaryKey
    private Integer id ;

    @Column(value = "user_name")
    private String userName ;

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
}
