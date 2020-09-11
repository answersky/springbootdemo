package com.answer.java8.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * created by liufeng
 * 2020/9/1
 */
public class Test2 {
    public static void main(String[] args) {
        String[] arrayOfWords = {"Goodbye", "World"};
        List<String> list=Arrays.asList(arrayOfWords);
        list.stream().map(w->w.split("")).flatMap(Arrays::stream).forEach(System.out::println);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).collect(toList());
        pairs.stream().map(ints -> ints[0]+","+ints[1]).forEach(System.out::println);
    }
}
