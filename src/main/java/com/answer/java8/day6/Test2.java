package com.answer.java8.day6;

import java.time.LocalDate;
import java.time.Period;

/**
 * created by liufeng
 * 2020/9/9
 */
public class Test2 {
    public static void main(String[] args) {
        Period tenDays = Period.between(LocalDate.of(2014, 3, 8),LocalDate.of(2014, 3, 18));
        System.out.println(tenDays.getDays());
    }
}
