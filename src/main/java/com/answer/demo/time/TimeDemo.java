package com.answer.demo.time;

import org.apache.commons.lang3.time.FastDateFormat;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * created by liufeng
 * 2020/6/10
 */
public class TimeDemo {
    public static void main(String[] args) {
        FastDateFormat dateFormat=FastDateFormat.getInstance("yyyy-MM-dd");
        FastDateFormat da=FastDateFormat.getInstance("dd");
        System.out.println(da.format(new Date()));
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));
        String enTime=dateFormat.format(cale.getTime());
        System.out.println("当月最后一天:"+enTime);
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH,-1);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String endTime=dateFormat.format(ca.getTime());
        System.out.println("上个月最后一天:"+endTime);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        String endTime1=dateFormat.format(cal.getTime());
        System.out.println("下个月最后一天:"+endTime1);

        LocalDate today = LocalDate.now();
        System.out.println(today.getDayOfMonth());

    }
}
