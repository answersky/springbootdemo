package com.answer.thread;

/**
 * created by liufeng
 * 2020/8/21
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal=new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        //ThreadLocal  保证线程中使用的变量值独立互不影响
        threadLocal.set("main");
        Thread thread=new Thread(()->{
            threadLocal.set("sub");
            sys();
        });
        thread.start();
        thread.join();
       sys();
    }

    private static void sys(){
        System.out.println(threadLocal.get());
    }
}
