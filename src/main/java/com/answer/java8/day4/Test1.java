package com.answer.java8.day4;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * created by liufeng
 * 2020/9/4
 */
public class Test1 {
    //peek 调试输出
    public static void main(String[] args) {
        List<Integer> nums= Lists.newArrayList(1,2,3,4);
        List<Integer> result=nums.stream().filter(integer -> integer>=2).peek(x->System.out.println("after filter:"+x)).limit(2).peek(x->System.out.println("after limit:"+x)).collect(Collectors.toList());
        System.out.println(result);
    }
}
