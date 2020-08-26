package com.answer.thread;

/**
 * created by liufeng
 * 2020/8/21
 */
public class ThreadLocalTest {

    public static void main(String[] args) throws InterruptedException {
        //ThreadLocal  保证线程中使用的变量值独立互不影响
        ThreadLocal<String> threadLocal=new ThreadLocal<>();
        threadLocal.set("main");
        Thread thread=new Thread(()->{
            System.out.println(threadLocal.get());
            threadLocal.set("sub");
            System.out.println(threadLocal.get());
        });
        thread.start();
        thread.join();
        System.out.println(threadLocal.get());
    }
}
