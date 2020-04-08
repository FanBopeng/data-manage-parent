package com.dynamic.add.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dynamic.add.entity.ConnectionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 数据源连接表 Mapper 接口
 */
@Mapper
public interface ConnectionMapper extends BaseMapper<ConnectionEntity> {

    List<ConnectionEntity> getAllList () ;

}