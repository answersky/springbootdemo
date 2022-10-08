package com.answer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/9/27 16:10
 * @className: RedisTemplateConfig
 * @packageName: com.answer.config
 * @description: redisTemplate 序列化配置
 */
@Configuration
public class RedisTemplateConfig {
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> objectObjectRedisTemplate = new RedisTemplate<>();
        objectObjectRedisTemplate.setKeySerializer(new StringRedisSerializer());
        objectObjectRedisTemplate.setHashKeySerializer(new StringRedisSerializer());
        objectObjectRedisTemplate.setValueSerializer(new StringRedisSerializer());
        objectObjectRedisTemplate.setHashValueSerializer(new StringRedisSerializer());

        objectObjectRedisTemplate.setConnectionFactory(connectionFactory);

        return objectObjectRedisTemplate;
    }
}
