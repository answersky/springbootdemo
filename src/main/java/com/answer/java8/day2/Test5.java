package com.answer.java8.day2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * created by liufeng
 * 2020/9/1
 */
public class Test5 {
    public static void main(String[] args) {
        //boxed()   IntStream转换成Stream<Integer>
        List<Integer> nums=IntStream.range(1,100).filter(i->i%2==0).boxed().collect(Collectors.toList());
        System.out.println(nums);
        List<Integer> numbers=IntStream.rangeClosed(1,100).boxed().collect(Collectors.toList());
        System.out.println(numbers);
    }
}
