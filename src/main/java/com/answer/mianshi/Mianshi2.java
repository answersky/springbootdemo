package com.answer.mianshi;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * created by liufeng
 * 2018/9/17
 */
public class Mianshi2 {
    //把a,b,c放到ArrayList d中，并且把d放到HashMap h中，key为e

    public static void main(String[] args) {
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("a",1);
        System.out.println("1".equals(map.get("a")));
        System.out.println("1".equals(String.valueOf(map.get("a"))));
    }
}
