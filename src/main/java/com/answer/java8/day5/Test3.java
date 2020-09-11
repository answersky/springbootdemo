package com.answer.java8.day5;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * created by liufeng
 * 2020/9/8
 */
public class Test3 {
    public static void main(String[] args) {
        long s=System.currentTimeMillis();
        dosomething();
        dosomething();
        dosomething();
        System.out.println("执行三次同步计算花费："+(System.currentTimeMillis()-s));

        long s1=System.currentTimeMillis();
        List<CompletableFuture<Integer>> futures=IntStream.rangeClosed(1,3).boxed().map(num->CompletableFuture.supplyAsync(()->dosomething())).collect(Collectors.toList());
        try {
            List<Integer> futureList=futures.stream().map(future->future.join()).collect(Collectors.toList());
            System.out.println("执行三次异步计算花费："+(System.currentTimeMillis()-s1));
            System.out.println(futureList);
            System.out.println("执行三次异步获取结果花费："+(System.currentTimeMillis()-s1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Integer dosomething() {
        int count=0;
        for(int i=1;i<=100;i++){
            count=count+i;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("dosomething  返回结果："+count);
        return count;
    }
}
