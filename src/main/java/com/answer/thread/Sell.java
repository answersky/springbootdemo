package com.answer.thread;

/**
 * created by liufeng
 * 2018/8/24
 */
public class Sell {
    public static void main(String[] args) {
        Thread st=new Thread(new SellTarget(),"窗口1");
        Thread st1=new Thread(new SellTarget(),"窗口2");
        st.start();
        st1.start();
    }
}

class SellTarget extends Thread{
    @Override
    public void run(){
        Target target=new Target();
        for(int i=0;i<1000;i++){
            target.sell();
        }
    }
}