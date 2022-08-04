package com.coin.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    private String namespace = "public-api-office:";

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void setNamespace(String namespace) {
        if (namespace != null)
            this.namespace = namespace + ":";
    }

    public void set(String k, Object v, long time) {
        String key = namespace + k;
        if (v instanceof String && stringRedisTemplate != null) {
            stringRedisTemplate.opsForValue().set(key, (String) v);
        } else {
            redisTemplate.opsForValue().set(key, v);
        }
        if (time > 0) redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    public void set(String k, Object v) {
        set(k, v, -1);
    }

    public boolean contains(String key) {
        return redisTemplate.hasKey(namespace + key);
    }

    public String get(String k) {
        if (stringRedisTemplate != null) {
            return stringRedisTemplate.opsForValue().get(namespace + k);
        } else {
            return (String) redisTemplate.opsForValue().get(namespace + k);
        }
    }

    public <T> T getObject(String k) {
        ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        return (T) valueOps.get(namespace + k);
    }

    public void remove(String key) {
        redisTemplate.delete(namespace + key);
    }

    public long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    public boolean setExpire(String key, long time) {
        return redisTemplate.expire(namespace + key, time, TimeUnit.SECONDS);
    }

    public Set<String> keys(String pattern) {
        return redisTemplate.keys(namespace + pattern);
    }

    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(namespace + key, delta);
    }

    public Double increment(String key, double delta) {
        return redisTemplate.opsForValue().increment(namespace + key, delta);
    }

    public boolean setNx(String key, String val, int sec){
        return redisTemplate.opsForValue().setIfAbsent(namespace + key, val, Duration.ofSeconds(sec));
    }

}
