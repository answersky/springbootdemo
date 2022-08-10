package com.answer.thread;

import cn.hutool.core.date.format.FastDateFormat;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/8/10 17:19
 * @className: ScheduleThreadTest
 * @packageName: com.answer.thread
 * @description: 定时线程池
 */
public class ScheduleThreadTest {
    private static final FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
    private static int time = 1000;

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        //定时1秒后执行
        System.out.println("开始时间" + format.format(new Date()));
        scheduledExecutorService.schedule(new Task(time), time, TimeUnit.MILLISECONDS);


        //定时周期执行
//        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+"    2秒循环执行一次");
//                System.out.println("当前时间"+format.format(new Date()));
//            }
//        },1000,2000, TimeUnit.MILLISECONDS);

    }


    static class Task implements Runnable {
        private int time;
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);

        public Task(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            System.out.println("当前定时间隔" + time + "毫秒执行一次");
            //变频执行定时任务
            int executeTime = time + 1000;
            scheduledExecutorService.schedule(new Task(executeTime), executeTime, TimeUnit.MILLISECONDS);
            System.out.println("当前时间" + format.format(new Date()));
        }
    }

}


