package com.answer.java8.day7;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * created by liufeng
 * 2020/9/10
 */
public class Test2 {
    public static void main(String[] args) {
        //格式化
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
        LocalDateTime date=LocalDateTime.now();
        String time=date.format(dateTimeFormatter);
        System.out.println(time);
    }
}
