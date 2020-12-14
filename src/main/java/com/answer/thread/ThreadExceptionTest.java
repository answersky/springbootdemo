package com.answer.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * created by liufeng
 * 2020/12/14
 * 线程捕获异常方式
 */
public class ThreadExceptionTest {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-runner-%d").build();
        ExecutorService fixedThreadPool = new ThreadPoolExecutor(2,2,100L,TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(5),namedThreadFactory);
        /*fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程："+Thread.currentThread().getName()+"执行完成");
                throw new RuntimeException("子线程执行异常");
            }
        });*/
        for(int i=0;i<10 ;i++){
            try {
                Future future=fixedThreadPool.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("子线程："+Thread.currentThread().getName()+"执行完成");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        System.out.println(Thread.currentThread().getName()+"执行完成");
        fixedThreadPool.shutdown();
    }
}
