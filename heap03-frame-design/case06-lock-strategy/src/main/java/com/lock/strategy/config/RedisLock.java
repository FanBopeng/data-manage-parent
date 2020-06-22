package com.lock.strategy.config;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@Component
public class RedisLock {

    @Resource
    private Jedis jedis ;

    /**
     * 获取锁
     */
    public boolean getLock (String key,String value,long expire){
        try {
            String result = jedis.set( key, value, "nx", "ex", expire);
            return result != null;
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null) jedis.close();
        }
        return false ;
    }

    /**
     * 释放锁
     */
    public boolean unLock (String key){
        try {
            Long result = jedis.del(key);
            return result > 0 ;
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null) jedis.close();
        }
        return false ;
    }
}
