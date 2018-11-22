package com.answer.thread;

/**
 * created by liufeng
 * 2018/8/24
 */
//卖票
public class Target {
    //100张票
    private static int total=1000;
    Object mutex = new Object();

    public void sell(){
        synchronized (mutex){
            if(total>0){
                total=total-1;
                System.out.println(Thread.currentThread().getName()+"余票："+total);
            }else {
                System.out.println("售完");
            }
        }

    }

}
