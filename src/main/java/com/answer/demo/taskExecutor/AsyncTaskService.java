package com.answer.demo.taskExecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * created by liufeng
 * 2018/9/13
 */
@Service
public class AsyncTaskService {
    @Async
    public void executorTask(Integer i){
        System.out.println("taskA:"+i);
    }

    @Async
    public void executorTaskB(Integer i){
        System.out.println("taskB:"+(i+1));
    }
}
