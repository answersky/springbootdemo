package com.answer.java8.day7;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * created by liufeng
 * 2020/9/10
 */
public class Test1 {
    public static void main(String[] args) {
        LocalDate date=LocalDate.of(2012,3,20);
        //加1周
        date=date.plusWeeks(1);
        System.out.println(date);
        //加8年减1个月
        date=date.plusYears(8).minusMonths(1);
        System.out.println(date);
        date=date.plusDays(3);
        System.out.println(date);


        LocalDate time=LocalDate.of(2020,2,20);
        //当月最后一天
        time=time.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(time);
    }
}
