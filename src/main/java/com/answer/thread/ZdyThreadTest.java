package com.answer.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.concurrent.*;

/**
 * created by liufeng
 * 2020/11/26
 * 自定义线程
 */
public class ZdyThreadTest {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-runner-%d").build();
        ExecutorService fixedThreadPool = new ThreadPoolExecutor(1,1,100L,TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());
        List<String> list= Lists.newArrayList("1","2");
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //主线程执行完，list被清空，这里不会被执行
                if(CollectionUtils.isNotEmpty(list)){
                    System.out.println("线程执行中");
                }
            }
        });
        fixedThreadPool.shutdown();
        list.clear();
        System.out.println("主线程执行中");
    }
}

