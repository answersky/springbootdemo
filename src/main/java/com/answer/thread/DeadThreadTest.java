package com.answer.thread;

/**
 * created by liufeng
 * 2021/10/11
 * 死锁
 */
public class DeadThreadTest {
    private static final String lock1="1";
    private static final String lock2="2";

    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (lock1){
                        System.out.println("线程"+Thread.currentThread().getName()+"开始执行");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock2){
                            System.out.println("线程"+Thread.currentThread().getName()+"执行结束");
                        }
                    }
                }
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    System.out.println("线程"+Thread.currentThread().getName()+"开始执行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1){
                        System.out.println("线程"+Thread.currentThread().getName()+"执行结束");
                    }
                }
            }
        });
        thread1.setName("111");
        thread2.setName("222");
        thread1.start();
        thread2.start();
    }
}
