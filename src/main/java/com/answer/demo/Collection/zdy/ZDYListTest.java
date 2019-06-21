package com.answer.demo.Collection.zdy;

/**
 * created by liufeng
 * 2019/6/21
 */
public class ZDYListTest {
    public static void main(String[] args) {
        ZDYList<String> zdyList=new ZDYList<String>(1);
        zdyList.add("123");
//        zdyList.add("12");
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
    }
}
