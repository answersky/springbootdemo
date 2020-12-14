package com.answer.signin;

import redis.clients.jedis.Jedis;

import java.time.LocalDate;
import java.util.Map;

/**
 * created by liufeng
 * 2020/12/14
 */
public interface IDoSignService {
    /**
     * 签到
     * @param uid  用户id
     * @param date 签到日期
     */
    boolean doSignIn(Jedis jedis,Integer uid, LocalDate date);

    /**
     * 检查是否签到
     * @param uid
     * @param date
     * @return
     */
    boolean checkSign(Jedis jedis,Integer uid, LocalDate date);

    /**
     * 统计签到次数
     * @param uid
     * @param date
     * @return
     */
    long getSignCount(Jedis jedis,Integer uid, LocalDate date);

    /**
     * 获取当月连续签到次数
     * @param uid
     * @param date
     * @return
     */
    long getContinuousSignCount(Jedis jedis,Integer uid, LocalDate date);

    /**
     * 获取首次签到日期
     * @param uid
     * @param date
     * @return
     */
    LocalDate getFirstSignDate(Jedis jedis,Integer uid, LocalDate date);

    /**
     * 获取当月签到情况
     * @param uid
     * @param date
     * @return
     */
    Map<String, Boolean> getSignInfo(Jedis jedis,Integer uid, LocalDate date);
}
