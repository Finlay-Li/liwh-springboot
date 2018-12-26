package com.dodou.liwh.redis.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author: Liwh
 * @ClassName: RedisConfig
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-29 4:28 PM
 */
@Configuration
public class RedisConfig {

    public RedisConfig() {
    }

    @Bean
    @ConditionalOnMissingBean(name = {"redisTemplate"})//Bean（name） 和 Class（class） 的区别要清楚
    public RedisTemplate<Object,Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericFastJsonRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericFastJsonRedisSerializer());
        return redisTemplate;
    }

    @Bean//只能操作String类型，所以无泛型
    @ConditionalOnMissingBean(name = {"stringRedisTemplate"})
    public StringRedisTemplate getStringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
        return stringRedisTemplate;
    }

    //Redis Lock

}
