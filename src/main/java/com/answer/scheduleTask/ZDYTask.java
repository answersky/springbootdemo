package com.answer.scheduleTask;

import cn.hutool.core.date.format.FastDateFormat;

import java.util.Date;
import java.util.TimerTask;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/10/8 18:05
 * @className: ZDYTask
 * @packageName: com.answer.scheduleTask
 * @description: 指定时间执行任务
 */
public class ZDYTask extends TimerTask {
    FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    @Override
    public void run() {
        System.out.println("当前任务执行时间：" + format.format(new Date()));
    }
}
