package com.answer.mianshi;

/**
 * created by liufeng
 * 2018/9/18
 */
public class Mianshi3 {
    public static void main(String[] args) {
        Thread thread=new MianshiThread(0);
        thread.start();
        Thread thread1=new MianshiThread(0);
        thread1.start();
        Thread thread2=new MianshiThread(1);
        thread2.start();
        Thread thread3=new MianshiThread(1);
        thread3.start();
    }
}


class MianshiThread extends Thread{
    private int i;
    private int j;
    public MianshiThread(int i){
        this.i=i;
    }

    @Override
    public void run(){
        if(i==0){
            j++;
        }else {
            j--;
        }
        System.out.println(j);
    }
}