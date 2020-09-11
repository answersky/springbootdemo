package com.answer.java8.day3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * created by liufeng
 * 2020/9/2
 */
public class Test2 {
    public static void main(String[] args) {
        List<Integer> nums=Stream.iterate(1, integer -> integer+1).limit(100).collect(Collectors.toList());
        System.out.println(nums);
        //流计算1到100的数字和
        long s1=System.currentTimeMillis();
        Long total= Stream.iterate(1L,integer -> integer+1).limit(10000000).reduce(0L,Long::sum);
        System.out.println("total:"+total+"  花费的时间："+(System.currentTimeMillis()-s1));
        long s2=System.currentTimeMillis();
        Long total1= LongStream.rangeClosed(1L, 10000000).sum();
        System.out.println("total1:"+total1+"  花费的时间："+(System.currentTimeMillis()-s2));

        //并行流处理  iterate存在了自动装箱拆箱操作，而数值流不存在这种操作，所以比较节省时间
        long s3=System.currentTimeMillis();
        Long total3= Stream.iterate(1L,integer -> integer+1).limit(10000000).parallel().reduce(0L,Long::sum);
        System.out.println("total3:"+total3+"  花费的时间："+(System.currentTimeMillis()-s3));

    }
}
