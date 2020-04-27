package com.post.gresql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.post.gresql.entity.UserJsonEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserJsonMapper extends BaseMapper<UserJsonEntity> {
    int addUserJson(UserJsonEntity userJsonEntity) ;
}
