package com.mvc.style.dao.impl;

import com.mvc.style.dao.BaseInfoDao;
import com.mvc.style.entity.BaseInfo;
import com.mvc.style.entity.BaseInfoExample;
import com.mvc.style.mapper.BaseInfoExtendMapper;
import com.mvc.style.mapper.BaseInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BaseInfoDaoImpl implements BaseInfoDao {

    @Resource
    private BaseInfoMapper baseInfoMapper ;
    @Resource
    private BaseInfoExtendMapper baseInfoExtendMapper ;

    @Override
    public int insert(BaseInfo record) {
        return baseInfoMapper.insert(record);
    }

    @Override
    public List<BaseInfo> selectByExample(BaseInfoExample example) {
        return baseInfoMapper.selectByExample(example);
    }

    @Override
    public int updateByPrimaryKey(BaseInfo record) {
        return baseInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public BaseInfo selectByPrimaryKey(Integer id) {
        return baseInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return baseInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public BaseInfo getById(Integer id) {
        return baseInfoExtendMapper.getById(id);
    }
}
