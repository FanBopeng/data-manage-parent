package com.visual.chart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.visual.chart.entity.ProductInfo;
import com.visual.chart.mapper.ProductInfoMapper;
import com.visual.chart.service.ProductInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {

    @Resource
    private ProductInfoMapper productInfoMapper ;

    @Override
    public Integer countNum() {
        return productInfoMapper.countNum();
    }

    @Override
    public Double sumAll() {
        return productInfoMapper.sumAll();
    }

    @Override
    public List<Map<String, Double>> groupSum() {
        return productInfoMapper.groupSum();
    }

    @Override
    public Double average() {
        return productInfoMapper.average();
    }
}
