package com.answer.java8.day1;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * created by liufeng
 * 2020/8/31
 */
public class Test2 {

    public static void main(String[] args) {
        List<Dish> menu = Lists.newArrayList(new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        //根据类型分类
        Map<Dish.Type,List<Dish>> map=menu.stream().filter((Dish d)->!d.isVegetarian()).collect(groupingBy(Dish::getType));
        System.out.println(map);
    }
}
