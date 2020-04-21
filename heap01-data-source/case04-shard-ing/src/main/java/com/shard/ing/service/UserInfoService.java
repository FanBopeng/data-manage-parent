package com.shard.ing.service;

import com.shard.ing.entity.UserInfoEntity;

import java.util.List;

public interface UserInfoService {

    void batchInsert(List<UserInfoEntity> userList);

    UserInfoEntity selectByPhone (String userPhone);
}
