package com.ckhouse.cluster.service;

import com.ckhouse.cluster.entity.DataAllEntity;
import com.ckhouse.cluster.mapper.DataAllMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataAllServiceImpl implements DataAllService {

    @Resource
    private DataAllMapper dataAllMapper ;

    @Override
    public List<DataAllEntity> getList() {
        return dataAllMapper.getList();
    }
}
