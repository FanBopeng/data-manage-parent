package com.visual.chart.mapper;

import com.visual.chart.entity.ProductInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
    Integer countNum () ;

    Double sumAll () ;

    List<Map<String,Double>> groupSum ();

    Double average () ;
}
