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
    public static void main(String[] args) {
        System.out.println("前一天：" + preDay());
        System.out.println("前一天凌晨：" + preDay());
        System.out.println("后一天：" + nextDay());
    }

    private static Date preDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 前一天的0点
     *
     * @return
     */
    private static Date preDayToDawn() {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        String time = fastDateFormat.format(calendar.getTime());
        Date nowTime = null;
        try {
            nowTime = fastDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return nowTime;
    }

    private static Date nextDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }
}
