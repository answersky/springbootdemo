package com.answer.mianshi;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * created by liufeng
 * 2019/1/21
 */
public class Time {
    public static void main(String[] args) throws ParseException {
        FastDateFormat sdf=FastDateFormat.getInstance("yyyy-MM-dd");
        Date date=sdf.parse("2018-09-08");
        System.out.println(date);
    }
}
