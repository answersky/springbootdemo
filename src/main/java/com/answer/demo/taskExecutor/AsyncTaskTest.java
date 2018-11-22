package com.answer.demo.taskExecutor;

import com.answer.config.TaskExecutorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * created by liufeng
 * 2018/9/13
 */
public class AsyncTaskTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService=context.getBean(AsyncTaskService.class);
        for(int i=1;i<=10;i++){
            asyncTaskService.executorTask(i);
            asyncTaskService.executorTaskB(i);
        }
        context.close();
    }
}
