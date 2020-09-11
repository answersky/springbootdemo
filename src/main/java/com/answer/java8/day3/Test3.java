package com.answer.java8.day3;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * created by liufeng
 * 2020/9/2
 */
public class Test3 {
    public static void main(String[] args) {
        long s=System.currentTimeMillis();
        long[] nums=LongStream.rangeClosed(1L, 10000000).toArray();
        ForkJoinSumCalculator forkJoinSumCalculator=new ForkJoinSumCalculator(nums,0,nums.length);
        long all=new ForkJoinPool().invoke(forkJoinSumCalculator);
        System.out.println(all+" 花费的时间："+(System.currentTimeMillis()-s));
    }
}
