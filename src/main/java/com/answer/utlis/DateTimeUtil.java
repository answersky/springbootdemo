package com.answer.utlis;

import cn.hutool.core.date.format.FastDateFormat;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/10/10 17:00
 * @className: DateTimeUtil
 * @packageName: com.answer.utlis
 * @description:
 */
public class DateTimeUtil {
    static FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws ParseException {
        String sTime = "2022-10-01 18:00:00";
        Date startTime = format.parse(sTime);
//        Date nextTime = startTime;
//        do {
//            nextTime = getAfterDay(nextTime, 9);
//        } while (nextTime.getTime() < ((new Date()).getTime()));
//
//        System.out.println("下次开始时间:" + format.format(nextTime));


        //获取两个时间点中所有的时间节点
        Date endTime = format.parse("2022-10-15 17:00:00");
        Date nextTime = startTime;
        List<Date> times = new ArrayList<>();
        times.add(startTime);
        do {
            nextTime = getAfterDay(nextTime, 9);
            if (nextTime.getTime() <= (endTime.getTime())) {
                times.add(nextTime);
            } else {
                break;
            }

        } while (true);

        times.forEach(date -> {
            System.out.println("获取所有的时间节点:" + format.format(date));
        });
    }

    /**
     * 天/次
     *
     * @param startTime
     * @param frequency
     * @return
     */
    private static Date getAfterDay(Date startTime, Integer frequency) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.add(Calendar.DAY_OF_MONTH, frequency);
        Date time = calendar.getTime();
        String timeStr = format.format(time);
        System.out.println(timeStr);
        return time;
    }

    /**
     * 周/次
     *
     * @param startTime
     * @param frequency
     * @return
     */
    private static Date getAfterWeek(Date startTime, Integer frequency) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.add(Calendar.WEEK_OF_MONTH, frequency);
        Date time = calendar.getTime();
        String timeStr = format.format(time);
        System.out.println(timeStr);
        return time;
    }

    /**
     * 月/次
     *
     * @param startTime
     * @param frequency
     * @return
     */
    private static Date getAfterMonth(Date startTime, Integer frequency) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.add(Calendar.MONTH, frequency);
        Date time = calendar.getTime();
        String timeStr = format.format(time);
        System.out.println(timeStr);
        return time;
    }

    /**
     * 季/次
     *
     * @param startTime
     * @param frequency
     * @return
     */
    private static Date getAfterQuarter(Date startTime, Integer frequency) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        //1季度=3个月
        calendar.add(Calendar.MONTH, frequency * 3);
        Date time = calendar.getTime();
        String timeStr = format.format(time);
        System.out.println(timeStr);
        return time;
    }

    /**
     * 年/次
     *
     * @param startTime
     * @param frequency
     * @return
     */
    private static Date getAfterYear(Date startTime, Integer frequency) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        //1季度=3个月
        calendar.add(Calendar.YEAR, frequency);
        Date time = calendar.getTime();
        String timeStr = format.format(time);
        System.out.println(timeStr);
        return time;
    }
}
