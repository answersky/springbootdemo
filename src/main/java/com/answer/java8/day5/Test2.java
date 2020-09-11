package com.answer.java8.day5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * created by liufeng
 * 2020/9/8
 */
public class Test2 {
    public static void main(String[] args) {
        long s=System.currentTimeMillis();
        CompletableFuture<Integer> future=new CompletableFuture<>();
        new Thread(()->{
            try {
                int count=0;
                for(int i=1;i<=100;i++){
                    count=count+i;
                }
                Thread.sleep(1000);

                future.complete(count);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("执行异步不等待结果返回花费的时间："+(System.currentTimeMillis()-s));

        dosomething();
        try {
            Integer count=future.get();
            System.out.println("计算结果："+count);
            System.out.println("整个计算过程等待结果返回花费的时间："+(System.currentTimeMillis()-s));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void dosomething() {
        int count=0;
        for(int i=1;i<=100;i++){
            count=count+i;
        }
        System.out.println("dosomething  返回结果："+count);
    }
}
