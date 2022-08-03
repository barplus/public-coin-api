package com.coin.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {

    private RedisTemplate<String, Object> redisTemplate;



}
