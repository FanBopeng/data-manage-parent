package com.post.gresql.service;

import com.github.pagehelper.PageInfo;
import com.post.gresql.entity.UserEntity;

public interface UserService {

    UserEntity selectById (Integer id);

    Integer insert (UserEntity userEntity);

    PageInfo<UserEntity> pageQuery (int page,int pageSize);
}
