package com.answer.demo.Collection;

import org.assertj.core.util.Lists;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * created by liufeng
 * 2019/5/22
 */
public class HashSetTest {
    public static void main(String[] args) {
        List<String> list1= Lists.newArrayList("1","@","2","3");
        List<String> list2= Lists.newArrayList("1","@","k","3");
        Set<String> set=new LinkedHashSet<>();
        set.addAll(list1);
        set.addAll(list2);
        for(String str:set){
            System.out.println(str);
        }
    }
}
