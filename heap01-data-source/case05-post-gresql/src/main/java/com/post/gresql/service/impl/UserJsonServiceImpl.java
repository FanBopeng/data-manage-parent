package com.post.gresql.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.post.gresql.entity.UserJsonEntity;
import com.post.gresql.mapper.UserJsonMapper;
import com.post.gresql.service.UserJsonService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UserJsonServiceImpl extends ServiceImpl<UserJsonMapper, UserJsonEntity> implements UserJsonService {

    @Resource
    private UserJsonMapper userJsonMapper ;

    @Override
    public boolean addUserJson(UserJsonEntity userJsonEntity) {
        return userJsonMapper.addUserJson(userJsonEntity)>0;
    }

    @Override
    public UserJsonEntity findUserJson(Integer id) {
        return userJsonMapper.selectById(id);
    }
}
