package com.answer.demo.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * created by liufeng
 * 2018/11/7
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        concurrentHashMap.put("aa","aa");
        System.out.println(concurrentHashMap.get("aa"));
    }
}
