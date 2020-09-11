package com.answer.java8.day1;

/**
 * created by liufeng
 * 2020/8/31
 */
public interface FilterAppleService {

    boolean filterApple(Apple apple);

    /**
     * java8  接口可以定义默认实现方法
     */
    default void test(){
        System.out.println("Aaaa");
    }

    /**
     * 重载默认实现方法
     * @param name
     */
    default void test(String name){
        System.out.println(name);
    }
}
