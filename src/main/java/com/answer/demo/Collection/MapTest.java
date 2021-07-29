package com.answer.demo.Collection;

import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * created by liufeng
 * 2020/6/4
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,List<String>> map=new LinkedHashMap<>();
        List<String> list=map.get("12");
        if(CollectionUtils.isEmpty(list)){
            list=new ArrayList<>();
        }
        map.put("12",list);
        System.out.println("=======>"+map.get("12"));
        System.out.println(map.isEmpty());


        Map<String,String> maps=new LinkedHashMap<>();
        maps.put("a","aaaa");

        Map<String,String> map2=new LinkedHashMap<>();
        map2.put("sss","ssssss");
        maps.putAll(map2);

        System.out.println(maps);

    }
}
