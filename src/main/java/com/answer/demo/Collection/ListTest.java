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
        List<String> l2 = new ArrayList<>(ll.subList(1, 2));
        l2.add("new");
        System.out.println(ll);
        System.out.println(l2);
        ll.subList(1, 2).clear();
        System.out.println(ll);
    }
}
