package com.mvc.style.dao;

import com.mvc.style.entity.BaseInfo;
import com.mvc.style.entity.BaseInfoExample;

import java.util.List;

public interface BaseInfoDao {

    int insert(BaseInfo record);

    List<BaseInfo> selectByExample(BaseInfoExample example);

    int updateByPrimaryKey(BaseInfo record);

    BaseInfo selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    BaseInfo getById (Integer id) ;
}
