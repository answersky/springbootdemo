package com.answer.java8.day6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

/**
 * created by liufeng
 * 2020/9/9
 */
public class Test1 {
    public static void main(String[] args) {
        LocalDate date=LocalDate.of(2020,9,8);
        System.out.println(date);
        LocalDate now=LocalDate.now();
        System.out.println(now);

        int day = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println(day);
        LocalTime time=LocalTime.now();
        System.out.println(time);

        LocalDateTime dateTime=LocalDateTime.now();
        System.out.println(dateTime);
    }
}
