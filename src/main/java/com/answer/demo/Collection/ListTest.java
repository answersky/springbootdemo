package com.answer.demo.Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * created by liufeng
 * 2019/3/29
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> ll = new ArrayList<>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        List<String> l2 = new ArrayList<>();
        l2.add("new");
        System.out.println(ll);
        System.out.println(l2);

        //交集
//        ll.retainAll(l2);
//        System.out.println("交集："+ll);

        ll.removeAll(l2);
        System.out.println(ll);
    }
}
