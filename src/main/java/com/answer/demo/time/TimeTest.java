package com.answer.demo.time;

import cn.hutool.core.date.format.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * @author liufeng
 * 2021/12/30 10:03
 */
public class TimeTest {
    public static void main(String[] args) throws ParseException {
//        Calendar cdate = Calendar.getInstance();
//        cdate.setTime(new Date());
//        cdate.add(Calendar.DAY_OF_MONTH, 1);
//        Date nextDate=cdate.getTime();
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd");
        String time = fastDateFormat.format(new Date());
        System.out.println(time);
        Date currentDate = fastDateFormat.parse(time);
        System.out.println(currentDate);
    }
}
