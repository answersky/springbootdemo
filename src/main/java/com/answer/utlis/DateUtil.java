package com.answer.utlis;

import cn.hutool.core.date.format.FastDateFormat;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/6/6 9:39
 * @className: DateUtil
 * @packageName: com.answer.utlis
 * @description:
 */
public class DateUtil {
    public static void main(String[] args) throws ParseException {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd");
        FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
        String effectDate = "2022-07-03";
        Date effect = fastDateFormat.parse(effectDate);


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(effect);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date time = calendar.getTime();
        String timeStr = fastDateFormat.format(time);
        System.out.println(timeStr);
        Date date = null;
        try {
            date = format.parse(timeStr + " 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println((new Date()).after(date) ? "过期" : "有效");


        System.out.println("前一天凌晨：" + preDayToDawn(-1));
        System.out.println("前一天：" + preDay(-1));
        System.out.println("后一天：" + nextDay(1));
    }

    private static Date preDay(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * 前一天的0点
     *
     * @return
     */
    private static Date preDayToDawn(int day) throws ParseException {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);
        String date = fastDateFormat.format(calendar.getTime()) + " 00:00:00";
        return fastDateFormat.parse(date);
    }

    private static Date nextDay(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }
}
