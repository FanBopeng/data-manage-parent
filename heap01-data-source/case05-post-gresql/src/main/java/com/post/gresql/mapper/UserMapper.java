package com.post.gresql.mapper;

import com.post.gresql.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    UserEntity selectById (@Param("id") Integer id);

    Integer insert (UserEntity userEntity);

    List<UserEntity> selectList () ;
}
