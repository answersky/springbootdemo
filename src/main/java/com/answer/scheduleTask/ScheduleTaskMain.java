package com.answer.scheduleTask;

import cn.hutool.core.date.format.FastDateFormat;
import cn.hutool.core.util.ObjectUtil;
import com.answer.utlis.InterfaceAchieveClassUtil;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/8/10 18:16
 * @className: ScheduleTaskMain
 * @packageName: com.answer.scheduleTask
 * @description: 任务执行器
 */
public class ScheduleTaskMain {
    private static final FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);

        List<Class> clazzs = InterfaceAchieveClassUtil.getAllInterfaceAchieveClass(TaskService.class);
        for (Class clazz : clazzs) {
            try {
                TaskService taskService = (TaskService) clazz.newInstance();
                //获取类的方法 只有1个方法
                Method[] methods = taskService.getClass().getMethods();
                Timecorn timecorn = methods[0].getAnnotation(Timecorn.class);
                //默认值1000
                int time = 1000;
                if (ObjectUtil.isNotEmpty(timecorn)) {
                    time = timecorn.time();
                } else {
                    //没有设置定时时间则不自动执行任务
                    continue;
                }

                //定时周期执行
                scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + "    2秒循环执行一次");
                        taskService.doTask();
                        System.out.println("当前时间" + format.format(new Date()));
                    }
                }, 1000, time, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}
