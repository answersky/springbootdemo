package com.answer.java8.day1;

import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created by liufeng
 * 2020/8/31
 */
public class Test1 {

    public static void main(String[] args) {
        Apple aa=new Apple("red",20);
        Apple ab=new Apple("red",12);
        Apple ac=new Apple("green",16);
        List<Apple> apples= Lists.newArrayList(aa,ab,ac);
        List<Apple> list=filtApples(apples);
        System.out.println(list);

        //传递代码
        List<Apple> result=filtApples(apples,Apple::isGreenApple);
        System.out.println("green:"+result);
        List<Apple> re=filtApples(apples,Apple::isHeavyApple);
        System.out.println(">15:"+re);

        //λ表达式
        List<Apple> appleList=apples.stream().filter((Apple a)->a.getHeavy()>15).collect(Collectors.toList());
        System.out.println(appleList);
        List<String> colors=apples.stream().map(Apple::getColor).collect(Collectors.toList());
        System.out.println(colors);
    }

    public static List<Apple> filtApples(List<Apple> apples){
        List<Apple> result=new ArrayList<>();
        for(Apple apple:apples){
            if(Apple.isGreenApple(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filtApples(List<Apple> apples,FilterAppleService filterAppleService){
        List<Apple> result=new ArrayList<>();
        for(Apple apple:apples){
            if(filterAppleService.filterApple(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
