package com.master.slave.mapper;

import com.master.slave.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User selectById (@Param("id") Integer id);

    void insert (User user) ;
}
