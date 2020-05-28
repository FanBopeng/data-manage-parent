package com.cache.redis.util;

public class RedisKeyUtil {

    public static String getObectKey(Integer Id) {
        return String.format("entity:key:value:%s", Id);
    }

}
