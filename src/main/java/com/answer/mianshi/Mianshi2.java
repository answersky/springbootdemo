package com.answer.mianshi;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * created by liufeng
 * 2018/9/17
 */
public class Mianshi2 {
    //把a,b,c放到ArrayList d中，并且把d放到HashMap h中，key为e

    private static final String MESSAGE="taobao";

    public static void main(String[] args) {
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("a",1);
        System.out.println("1".equals(map.get("a")));
        System.out.println("1".equals(String.valueOf(map.get("a"))));

        int i = ((AA)null).met(2);
        System.out.println(i);


        String a = "tao" + "bao";
        String b = "tao";
        String c = "bao";
        System.out.println(a == MESSAGE);
        System.out.println((b + c) == MESSAGE);
    }
}
