package com.answer.signin;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by liufeng
 * 2020/12/14
 */
@Service
public class SigninServiceImpl implements IDoSignService{

    @Override
    public boolean doSignIn(Jedis jedis,Integer uid, LocalDate date) {
        //偏移位置  从0开始
        int offset = date.getDayOfMonth() - 1;
        return jedis.setbit(buildSignKey(uid, date), offset, true);
    }

    @Override
    public boolean checkSign(Jedis jedis,Integer uid, LocalDate date) {
        int offset = date.getDayOfMonth() - 1;
        return jedis.getbit(buildSignKey(uid, date), offset);
    }

    @Override
    public long getSignCount(Jedis jedis,Integer uid, LocalDate date) {
        return jedis.bitcount(buildSignKey(uid, date));
    }

    @Override
    public long getContinuousSignCount(Jedis jedis,Integer uid, LocalDate date) {
        int signCount = 0;
        String type = String.format("u%d", date.getDayOfMonth());
        List<Long> list = jedis.bitfield(buildSignKey(uid, date), "GET", type, "0");
        if (list != null && list.size() > 0) {
            // 取低位连续不为0的个数即为连续签到次数，需考虑当天尚未签到的情况
            long v = list.get(0) == null ? 0 : list.get(0);
            for (int i = 0; i < date.getDayOfMonth(); i++) {
                if (v >> 1 << 1 == v) {
                    // 低位为0且非当天说明连续签到中断了
                    if (i > 0){
                        break;
                    }
                } else {
                    signCount += 1;
                }
                v >>= 1;
            }
        }
        return signCount;
    }

    @Override
    public LocalDate getFirstSignDate(Jedis jedis,Integer uid, LocalDate date) {
        //bitpos key targetBit [start] [end]
        //计算位图指定范围（start到end，单位为字节，如果不指定就是获取全部）第一个偏移量对应的值等于targetBit的位置
        long pos = jedis.bitpos(buildSignKey(uid, date), true);
        return pos < 0 ? null : date.withDayOfMonth((int) (pos + 1));
    }

    @Override
    public Map<String, Boolean> getSignInfo(Jedis jedis,Integer uid, LocalDate date) {
        Map<String, Boolean> signMap = new HashMap<>(date.getDayOfMonth());
        String type = String.format("u%d", date.lengthOfMonth());
        List<Long> list = jedis.bitfield(buildSignKey(uid, date), "GET", type, "0");  //????
        System.out.println(list);
        if (list != null && list.size() > 0) {
            // 由低位到高位，为0表示未签，为1表示已签
            long v = list.get(0) == null ? 0 : list.get(0);
            for (int i = date.lengthOfMonth(); i > 0; i--) {
                LocalDate d = date.withDayOfMonth(i);
                signMap.put(formatDate(d, "yyyy-MM-dd"), v >> 1 << 1 != v);
                v >>= 1;  //?????
            }
        }
        return signMap;
    }

    //u:sign:1000:202012
    private static String buildSignKey(int uid, LocalDate date) {
        return String.format("u:sign:%d:%s", uid, formatDate(date));
    }

    private static String formatDate(LocalDate date) {
        return formatDate(date, "yyyyMM");
    }

    private static String formatDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

}
