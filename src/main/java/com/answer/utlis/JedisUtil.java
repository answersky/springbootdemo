package com.answer.utlis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * created by liufeng
 * 2020/4/23
 */
@Component
public class JedisUtil {
    @Autowired
    private JedisPool jedisPool;

    public Jedis getJedis(){
        return jedisPool.getResource();
    }

    /**
     * 通过key获取储存在redis中的value
     * 并释放连接
     * @param key
     * @return 成功返回value 失败返回null
     */
    public String get(Jedis jedis,String key) {
        return jedis.get(key);
    }

    public String set(Jedis jedis,String key,String value) {
        return jedis.set(key,value);
    }

    /**
     * <p>
     * 设置key value,如果key已经存在则返回0,nx==> not exist
     * </p>
     *
     * @param key
     * @param value
     * @return 成功返回1 如果存在 和 发生异常 返回 0
     */
    public Long setnx(Jedis jedis,String key, String value) {
        return jedis.setnx(key, value);
    }

    /**
     * <p>
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)。
     * </p>
     * <p>
     * 当 key 存在但不是字符串类型时，返回一个错误。
     * </p>
     *
     * @param key
     * @param value
     * @return 返回给定 key 的旧值。当 key 没有旧值时，也即是， key 不存在时，返回 nil
     */
    public String getSet(Jedis jedis,String key, String value) {
        return jedis.getSet(key, value);
    }

    public Long del(Jedis jedis,String key){
        return jedis.del(key);
    }

    /**
     * 为给定 key 设置生存时间，当 key 过期时(生存时间为 0 )，它会被自动删除。
     * @param key
     * @param value
     *            过期时间，单位：秒
     * @return 成功返回1 如果存在 和 发生异常 返回 0
     */
    public Long expire(Jedis jedis,String key, int value) {
        return jedis.expire(key, value);
    }

    public Long ttl(Jedis jedis,String key){
        return jedis.ttl(key);
    }

    /**
     * 返还到连接池
     *
     */
    public void close() {
        jedisPool.close();
    }
}
