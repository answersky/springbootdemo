package com.answer.demo.concurrent;

import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by liufeng
 * 2018/11/6
 */
public class ReentrantLockTest implements Runnable{
    private static ReentrantLock reentrantLock=new ReentrantLock(true);

    public static void main(String[] args) {
        ReentrantLockTest test=new ReentrantLockTest();
        Thread t1=new Thread(test,"1");
        Thread t2=new Thread(test,"2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            try {
                reentrantLock.lock();
                System.out.println("lock-"+Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }
    }
}
