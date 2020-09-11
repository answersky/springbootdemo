package com.answer.java8.day5;

import java.util.concurrent.*;

/**
 * created by liufeng
 * 2020/9/8
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        Future<Integer>  future=executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int count=0;
                for(int i=1;i<=100;i++){
                    count=count+i;
                }
                System.out.println(count);
                return count;
            }
        });
        for(int i=1;i<=10;i++){
            System.out.println(i);
        }

        Integer count=future.get(1,TimeUnit.SECONDS);
        executorService.shutdown();
    }
}
