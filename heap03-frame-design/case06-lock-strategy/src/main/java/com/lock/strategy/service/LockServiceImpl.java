package com.lock.strategy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lock.strategy.config.RedisLock;
import com.lock.strategy.entity.DataLockEntity;
import com.lock.strategy.mapper.DataLockMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class LockServiceImpl extends ServiceImpl<DataLockMapper, DataLockEntity> implements LockService {

    @Resource
    private RedisLock redisLock ;
    @Resource
    private DataLockMapper dataLockMapper ;

    @Override
    public Boolean getLock(String key,String value,long expire) {
        return redisLock.getLock(key,value,expire) ;
    }

    @Override
    public Boolean updateByLock(Integer id,Integer lockVersion) {
        return dataLockMapper.updateByLock(id,lockVersion)>0;
    }

    @Override
    public Boolean updateByInventory(Integer id) {
        DataLockEntity dataLockEntity = dataLockMapper.getById(id);
        if (dataLockEntity != null){
            return dataLockMapper.updateByInventory(id,dataLockEntity.getInventory())>0 ;
        }
        return false ;
    }
}
