package com.answer.thread;

import java.util.concurrent.ExecutionException;

/**
 * created by liufeng
 * 2018/8/24
 */
public class ThreadTest extends Thread{

    @Override
    public void run(){
        System.out.println("线程运行");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread tt=new MyThread();
        tt.start();
        tt.join();
        System.out.println("主线程执行");

       /* ExecutorService es=Executors.newFixedThreadPool(2);
        Future future=es.submit(new CallableTest(1));
        Object resutl=future.get();
        System.out.println(resutl);
        es.shutdown();*/
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("子线程执行。。。。");
    }
}