package com.answer.demo.Collection.zdy;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * created by liufeng
 * 2019/6/21
 */
public class ZDYListTest {
    public static void main(String[] args) {
        ZDYList<String> zdyList=new ZDYList<String>(1);
        zdyList.add("123");
        zdyList.add("12");
        System.out.println("zdyList size:"+zdyList.size());
        //遍历元素
        /*for(int i=0;i<zdyList.size();i++){
            System.out.println("zdyList 中的元素："+ zdyList.get(i));
        }*/
        //foreach 遍历
        for(String element:zdyList){
            System.out.println("zdyList 中的元素："+ element);
        }
        System.out.println("元素的位置:"+zdyList.indexOf("1234"));
        System.out.println("=================================");
        ZDYLinkedList<String> zdyLinkedList=new ZDYLinkedList<>();
        zdyLinkedList.add("aaa");
        zdyLinkedList.add("bbb");
        for(String str:zdyLinkedList){
            System.out.println("linked element:"+str);
        }
        System.out.println("linked size:"+zdyLinkedList.size());
        System.out.println("linked i=1:"+zdyLinkedList.get(1));
        System.out.println("=================================");
        Set<String> set=new LinkedHashSet<>();
        set.add("3333");
        System.out.println("set value:"+set.size());
    }
}
