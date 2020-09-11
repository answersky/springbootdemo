package com.answer.java8.day2;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * created by liufeng
 * 2020/9/1
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> num= Lists.newArrayList(1,2,4,2,5,4);
        num.stream().filter(i->i%2==0).forEach(System.out::print);
        System.out.println("=====================");
        num.stream().filter(i->i%2==0).distinct().forEach(System.out::print);
    }
}
