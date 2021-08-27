package com.answer.demo.hutool;

import cn.hutool.bloomfilter.BitMapBloomFilter;

/**
 * created by liufeng
 * 2021/7/29
 */
public class HutoolBloom {
    public static void main(String[] args) {
        BitMapBloomFilter hutool=new BitMapBloomFilter(10);
        hutool.add("123");
        hutool.add("234");
        hutool.add("3345");
        System.out.println(hutool.contains("234"));


    }
}
