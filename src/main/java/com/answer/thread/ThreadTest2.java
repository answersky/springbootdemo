package com.answer.thread;

/**
 * created by liufeng
 * 2020/9/10
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        String result=getNum();
        System.out.println(result);
    }

    private static String getNum(){
        new Thread(()->{
            try {
                int count=0;
                for(int i=1;i<=100;i++){
                    count=count+i;
                }
                Thread.sleep(1000);
                System.out.println(count);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        return "计算完成";
    }
}
