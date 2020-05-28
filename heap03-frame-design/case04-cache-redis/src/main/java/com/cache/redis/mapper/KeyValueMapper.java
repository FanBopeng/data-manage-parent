package com.cache.redis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cache.redis.entity.KeyValueEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KeyValueMapper extends BaseMapper<KeyValueEntity> {

}
