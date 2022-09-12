package com.coin.service.util;

import org.springframework.data.redis.core.RedisTemplate;
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
    private String namespace = "public-api-office:";

    public void set(String k, Object v, long time) {
        String key = namespace + k;
        redisTemplate.opsForValue().set(key, v, time, TimeUnit.SECONDS);
    }

    public void set(String k, Object v) {
        set(k, v, -1);
    }

    public boolean contains(String key) {
        return redisTemplate.hasKey(namespace + key);
    }

    public String get(String k) {
        return (String) redisTemplate.opsForValue().get(namespace + k);
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

    public boolean setNx(String key, String val, long mill){
        return redisTemplate.opsForValue().setIfAbsent(namespace + key, val, Duration.ofMillis(mill));
    }

    public boolean setSetVal(String key, String val){
        Long count = redisTemplate.opsForSet().add(namespace + key, val);
        return count > 0;
    }

    public Set getSetVal(String key){
        Set set = redisTemplate.opsForSet().members(namespace + key);
        return set;
    }

    public long getSetSize(String key){
        long setLength = redisTemplate.opsForSet().size(namespace + key);
        return setLength;
    }

    public boolean removeSetSize(String key, String value){
        long removeCount = redisTemplate.opsForSet().remove(namespace + key,value);
        return removeCount > 0;
    }

}
