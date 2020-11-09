package com.mvc.style.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mvc.style.dao.DetailInfoDao;
import com.mvc.style.entity.DetailInfoEntity;
import com.mvc.style.mapper.DetailInfoMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 详情表 服务实现类
 * </p>
 *
 * @author mybatis-plus
 * @since 2020-11-02
 */
@Service
public class DetailInfoDaoImpl extends ServiceImpl<DetailInfoMapper, DetailInfoEntity> implements DetailInfoDao {

}
