package com.answer.demo.redis;

import com.answer.utlis.RedisUtil;
import org.assertj.core.util.Lists;

import java.util.List;

/**
 * created by liufeng
 * 2021/10/14
 * redis 实现异步队列
 */
public class RedisListTest {
    private static final String queue="asyn_key";

    //生产者
    public static void main(String[] args) {
        List<String> messages= Lists.newArrayList("msg1","msg2","msg3");
        for(String msg:messages){
            RedisUtil.lpush(queue,msg);
        }



    }
}
