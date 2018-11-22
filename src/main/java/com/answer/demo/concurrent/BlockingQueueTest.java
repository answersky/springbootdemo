package com.answer.demo.concurrent;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * created by liufeng
 * 2018/11/7
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockingQueue=new ArrayBlockingQueue<String>(10);
        try {
            arrayBlockingQueue.put("23");
            arrayBlockingQueue.put("233");
            Iterator<String> iterator=arrayBlockingQueue.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
