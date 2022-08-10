package com.answer.scheduleTask;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/8/10 18:39
 * @className: TaskA
 * @packageName: com.answer.scheduleTask
 * @description:
 */
public class TaskA implements TaskService {

    @Override
    @Timecorn(time = 2000)
    public void doTask() {
        System.out.println("taskA 任务执行");
    }

}
