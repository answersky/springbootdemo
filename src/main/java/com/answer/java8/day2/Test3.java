package com.answer.java8.day2;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * created by liufeng
 * 2020/9/1
 */
public class Test3 {
    public static void main(String[] args) {
        List<Integer> nums= Lists.newArrayList(4,5,3,9);
        Integer sum=nums.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);

        //最大值
        Integer max=nums.stream().reduce(0,Integer::max);
        System.out.println(max);

        //count
        Long count=nums.stream().count();
        System.out.println(count);
    }
}
