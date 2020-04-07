package com.master.slave.service;

import com.master.slave.entity.User;
import com.master.slave.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper ;

    public User selectById (Integer id) {
        return userMapper.selectById(id) ;
    }

    public void insert (User user){
        userMapper.insert(user);
    }
}
