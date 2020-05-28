package com.cache.redis.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cache.redis.entity.KeyValueEntity;
import com.cache.redis.mapper.KeyValueMapper;
import com.cache.redis.service.KeyValueService;
import com.cache.redis.service.RedisService;
import com.cache.redis.util.RedisKeyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;

@Service
public class KeyValueServiceImpl extends ServiceImpl<KeyValueMapper, KeyValueEntity> implements KeyValueService {

    @Resource
    private RedisService redisService ;

    @Override
    public KeyValueEntity select(Integer id) {
        // 查询缓存
        String redisKey = RedisKeyUtil.getObectKey(id) ;
        String value = redisService.get(redisKey) ;
        if (!StringUtils.isEmpty(value) && !value.equals("null")){
            return JSON.parseObject(value,KeyValueEntity.class);
        }
        // 查询库
        KeyValueEntity keyValueEntity = this.getById(id) ;
        if (keyValueEntity != null){
            // 缓存写入
            redisService.set(redisKey,JSON.toJSONString(keyValueEntity)) ;
        }
        // 返回值
        return keyValueEntity ;
    }

    @Override
    public boolean update(KeyValueEntity keyValueEntity) {
        // 更新数据
        boolean updateFlag = this.updateById(keyValueEntity) ;
        // 清除缓存
        if (updateFlag){
            redisService.delete(RedisKeyUtil.getObectKey(keyValueEntity.getId()));
        }
        return updateFlag ;
    }
}
