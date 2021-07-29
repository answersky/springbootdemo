package com.answer.demo;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.*;

/**
 * created by liufeng
 * 2021/7/15
 */
public class MyBloomFilter {

    /**
     * 布隆过滤器
     * @param args
     */
    public static void main(String[] args) {
        BloomFilter<String> filter=BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),500,0.01);
        List<String> lists = new ArrayList<String>(10);
        for (int i = 0; i < 500; i++) {
            String uuid = UUID.randomUUID().toString();
            filter.put(uuid);
            if(i<10){
                lists.add(uuid);
            }
        }

        for(String str:lists){

            if(filter.mightContain(str)){
                System.out.println(str+":"+true);
            }else {
                System.out.println(str+":"+false);
            }
        }

    }
}
