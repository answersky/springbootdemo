package com.answer.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
        /*Thread tt=new MyThread();
        tt.start();
        tt.join();
        System.out.println("主线程执行");*/
        System.out.println("===="+calue());
        System.out.println("main 执行完毕");
    }


    private static int calue() throws ExecutionException, InterruptedException {
        int num=0;
        for(int i=0;i<10000;i++){
            num=num+1;
        }
        System.out.println(num);
        ExecutorService es=Executors.newFixedThreadPool(2);
        es.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("延迟1s");
            }
        });
        es.shutdown();
        return num;
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("子线程执行。。。。");
    }
}