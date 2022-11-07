package com.answer.demo.redis;

import com.answer.utlis.RedisUtil;

/**
 * created by liufeng
 * 2021/10/14
 */
public class RedisConsumerTest {
    private static final String queue="asyn_key";
    //消费者
    public static void main(String[] args) throws InterruptedException {
        //brop 阻塞方式，阻塞timeout时长再请求数据
       /* while(true){
            System.out.println(RedisUtil.brpop(10,queue));
        }*/

       //会一直打印，不会阻塞，可通过sleep优化，缺点，造成消息延迟
        while(true){
            System.out.println(RedisUtil.rpop(queue));
            Thread.sleep(1000);
        }
    }
}
