package com.answer.java8.day8;

import java.util.stream.IntStream;

/**
 * created by liufeng
 * 2020/10/27
 */
public class LamadaForeachTest {
    public static void main(String[] args) {
        IntStream.rangeClosed(1,100).boxed().forEach(integer -> {
            if(integer==99){
                return;
            }
            System.out.println(integer);
        });
    }
}
