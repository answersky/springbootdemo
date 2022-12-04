package com.answer.java8.day2;

import org.assertj.core.util.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * created by liufeng
 * 2020/9/1
 */
public class Test1 {
    public static void main(String[] args) {
//        List<Integer> num= Lists.newArrayList(1,2,4,2,5,4);
//        num.stream().filter(i->i%2==0).forEach(System.out::print);
//        System.out.println("=====================");
//        num.stream().filter(i->i%2==0).distinct().forEach(System.out::print);
//

        Optional optional = Stream.of(1, 2, 3).filter(x -> x > 1).reduce((x, y) -> x + y);
        System.out.println(optional.get());

        List<Integer> list = Arrays.asList(4, 7, 9, 11, 12);
        list.stream()
                .peek(x -> System.out.println("stream: " + x))
                .map(x -> x + 2)
                .peek(x -> System.out.println("map: " + x))
                .filter(x -> x % 2 != 0)
                .peek(x -> System.out.println("filter: " + x))
                .limit(2)
                .peek(x -> System.out.println("limit: " + x))
                .collect(toList()).forEach(System.out::println);
    }
}
