package com.smart.tag.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.tag.entity.TagDataSet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TagDataSetMapper extends BaseMapper<TagDataSet> {

    Integer analyze (@Param("whereCondition") String whereCondition) ;

}
