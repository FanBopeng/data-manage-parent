package com.cache.redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cache.redis.entity.KeyValueEntity;

public interface KeyValueService extends IService<KeyValueEntity> {

    KeyValueEntity select (Integer id) ;

    boolean update (KeyValueEntity keyValueEntity) ;

}
