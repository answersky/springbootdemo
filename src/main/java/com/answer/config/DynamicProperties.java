package com.answer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * created by liufeng
 * 2020/7/14
 * 实现动态加载配置文件，不用重启项目
 */
@Component
public class DynamicProperties extends MapPropertySource {
    @Autowired
    private JedisPool jedisPool;
    @Resource
    private ConfigurableEnvironment environment;

    public DynamicProperties(String name, Map<String, Object> source) {
        super(name, source);
    }

    public DynamicProperties(){
        super("DynamicProperties",new LinkedHashMap<String, Object>());
    }

    public void initConfig(){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String value=jedis.get("host");
            this.source.put("host",value);
            environment.getPropertySources().addLast(this);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }
}
