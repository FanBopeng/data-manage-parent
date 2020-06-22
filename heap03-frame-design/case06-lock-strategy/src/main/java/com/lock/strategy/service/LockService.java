package com.lock.strategy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lock.strategy.entity.DataLockEntity;

public interface LockService extends IService<DataLockEntity> {

    Boolean getLock (String key,String value,long expire) ;

    Boolean updateByLock (Integer id,Integer lockVersion) ;

    Boolean updateByInventory (Integer id) ;
}
