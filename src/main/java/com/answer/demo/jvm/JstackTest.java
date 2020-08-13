package com.answer.demo.jvm;

/**
 * created by liufeng
 * 2020/8/13
 * 使用jstack查看Java线程情况
 */
public class JstackTest {
    /**
     * windows系统下查看  jps -l 查看java进程
     * jstack pid  查看线程情况
     * @param args
     * @throws InterruptedException
     */

    public static void main(String[] args) throws InterruptedException {
        while (true){
            System.out.println("1111");
            Thread.sleep(5000);
        }
    }
}

