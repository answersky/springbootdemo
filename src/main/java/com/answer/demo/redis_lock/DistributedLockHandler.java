package com.answer.demo.redis_lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * created by liufeng
 * 2020/12/3
 * redis 分布式锁实现
 */
@Service
public class DistributedLockHandler {
    @Autowired
    private JedisPool jedisPool;

    /**
     * 加锁
     * @param lockKey
     * @param getLockTimeOut  加锁过程的超时时长
     * @return
     */
    public boolean tryLock(String lockKey,long getLockTimeOut){
        Jedis jedis = jedisPool.getResource();
        try {
            long currentTime=System.currentTimeMillis();

            while (true){
                //判断加锁的这个过程是否超过了设置的超时时长
                if((System.currentTimeMillis()-currentTime)>getLockTimeOut){
                    System.out.println("加锁超时...");
                    break;
                }

                //尝试加锁
                long newLockTime=System.currentTimeMillis()+4;
                long result=jedis.setnx(lockKey,String.valueOf(newLockTime));
                if(result==1){
                    //加锁成功
                    return true;
                }
                //加锁不成功，判断原来的锁时间是否已经过期
                if(Long.valueOf(jedis.get(lockKey))>(System.currentTimeMillis())){
                    //未过期的等待尝试再次加锁
                    System.out.println("Try to get the Lock,and wait 100 millisecond....");
                    Thread.sleep(100);
                }else {
                    //过期
                    String preLockTime=jedis.getSet(lockKey,String.valueOf(newLockTime));
                    if((System.currentTimeMillis()>Long.valueOf(preLockTime))){
                        return true;
                    }else {
                        //未过期的等待尝试再次加锁
                        System.out.println("Try to get the Lock,and wait 100 millisecond....");
                        Thread.sleep(100);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("加锁过程异常");
        }finally {
            jedisPool.close();
        }
        return false;
    }

}
