package com.answer.demo.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by liufeng
 * 2021/7/20
 */
public class ReentrantLockTest1 {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();
    private static int stauts = 1;

    /**
     * 顺序打印ABC
     *
     * @param args
     */
    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("A:"+Thread.currentThread().getName());
            try {
                for (int i = 1; i <= 10; i++) {
                    lock.lock();
                    if (stauts != 1) {
                        conditionA.await();
                    }

                    System.out.println("A");
                    stauts = 2;
                    conditionB.signal();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }).start();
        new Thread(() -> {
            try {
                System.out.println("B:"+Thread.currentThread().getName());
                for (int i = 1; i <= 10; i++) {
                    lock.lock();
                    if (stauts != 2) {
                        conditionB.await();
                    }
                    System.out.println("B");
                    stauts = 3;
                    conditionC.signal();
                }


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("C:"+Thread.currentThread().getName());
                for (int i = 1; i <= 10; i++) {
                    lock.lock();
                    if (stauts != 3) {
                        conditionC.await();
                    }
                    System.out.println("C");
                    stauts = 1;
                    conditionA.signal();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        System.out.println("执行完成");
    }
}
