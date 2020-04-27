package com.post.gresql.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.post.gresql.entity.UserEntity;
import com.post.gresql.mapper.UserMapper;
import com.post.gresql.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper ;

    @Override
    public UserEntity selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public Integer insert(UserEntity userEntity) {
        return userMapper.insert(userEntity);
    }

    @Override
    public PageInfo<UserEntity> pageQuery(int page, int pageSize) {
        PageHelper.startPage(page,pageSize) ;
        List<UserEntity> userEntities = userMapper.selectList() ;
        PageInfo<UserEntity> pageInfo = new PageInfo<>(userEntities) ;
        return pageInfo ;
    }
}
