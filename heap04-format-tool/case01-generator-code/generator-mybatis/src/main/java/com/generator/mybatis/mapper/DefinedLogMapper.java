package com.generator.mybatis.mapper;

import com.generator.mybatis.pojo.DefinedLog;
import com.generator.mybatis.pojo.DefinedLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefinedLogMapper {
    int countByExample(DefinedLogExample example);

    int deleteByExample(DefinedLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DefinedLog record);

    int insertSelective(DefinedLog record);

    List<DefinedLog> selectByExample(DefinedLogExample example);

    DefinedLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DefinedLog record, @Param("example") DefinedLogExample example);

    int updateByExample(@Param("record") DefinedLog record, @Param("example") DefinedLogExample example);

    int updateByPrimaryKeySelective(DefinedLog record);

    int updateByPrimaryKey(DefinedLog record);
}