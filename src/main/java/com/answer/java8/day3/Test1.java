package com.answer.java8.day3;

import java.util.stream.Stream;

/**
 * created by liufeng
 * 2020/9/2
 */
public class Test1 {
    public static void main(String[] args) {
        //用流来生成斐波那契数列
        Stream.iterate(new int[]{0,1},ints -> new int[]{ints[1],ints[0]+ints[1]}).limit(20).forEach(ints -> System.out.print(ints[0]+","));
    }
}
