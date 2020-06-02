package com.visual.chart.mapper;

import com.visual.chart.entity.DataSetEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DataSetMapper {

    List<DataSetEntity> findAll () ;

    Double taskCount (@Param("columnName") String columnName,
                       @Param("tableName") String tableName) ;

    Double taskSum (@Param("columnName") String columnName,
                      @Param("tableName") String tableName) ;

    Double taskPercent (@Param("columnName") String columnName,
                        @Param("tableName") String tableName,
                        @Param("productId") Integer productId);
}
