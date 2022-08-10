package com.answer.scheduleTask;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/8/10 18:39
 * @className: TaskA
 * @packageName: com.answer.scheduleTask
 * @description:
 */
public class TaskB implements TaskService {

    @Override
    @Timecorn(time = 5000)
    public void doTask() {
        System.out.println("taskB 任务执行");
    }

}
