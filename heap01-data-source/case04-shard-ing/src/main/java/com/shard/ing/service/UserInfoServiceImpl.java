package com.shard.ing.service;

import com.shard.ing.entity.UserInfoEntity;
import com.shard.ing.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper ;

    @Override
    public void batchInsert(List<UserInfoEntity> userList) {
        userInfoMapper.batchInsert(userList);
    }

    @Override
    public UserInfoEntity selectByPhone(String userPhone) {
        return userInfoMapper.selectByPhone(userPhone);
    }
}
