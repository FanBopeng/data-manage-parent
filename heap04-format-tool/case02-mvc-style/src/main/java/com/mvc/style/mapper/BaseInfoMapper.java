package com.mvc.style.mapper;

import com.mvc.style.entity.BaseInfo;
import com.mvc.style.entity.BaseInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseInfoMapper {
    int countByExample(BaseInfoExample example);

    int deleteByExample(BaseInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseInfo record);

    int insertSelective(BaseInfo record);

    List<BaseInfo> selectByExample(BaseInfoExample example);

    BaseInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseInfo record, @Param("example") BaseInfoExample example);

    int updateByExample(@Param("record") BaseInfo record, @Param("example") BaseInfoExample example);

    int updateByPrimaryKeySelective(BaseInfo record);

    int updateByPrimaryKey(BaseInfo record);
}