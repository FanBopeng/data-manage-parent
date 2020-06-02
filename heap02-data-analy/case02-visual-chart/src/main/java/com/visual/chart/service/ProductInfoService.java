package com.visual.chart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.visual.chart.entity.ProductInfo;

import java.util.List;
import java.util.Map;

public interface ProductInfoService extends IService<ProductInfo> {
    Integer countNum () ;

    Double sumAll () ;

    List<Map<String,Double>> groupSum ();

    Double average () ;
}
