package com.answer.mianshi;


/**
 * created by liufeng
 * 2020/9/10
 */
public class Kls {

    /**
     * 快乐数
     * 19  返回  true
     *
     * 1^2+9^2=82
     * 8^2+6^2=68
     * 6^2+8^2=100
     * 1^2+0^2+0^2=1
     * @param args
     */

    public static void main(String[] args) {
        int num=20;
        System.out.println("是否是快乐数："+getKls(num));
    }

    private static boolean getKls(int num) {
        String numStr=String.valueOf(num);
        char[] nums=numStr.toCharArray();
        int count=0;
        for(char ch:nums){
            int i=Integer.parseInt(String.valueOf(ch));
            count=count+i*i;
        }
        System.out.println(count);
        if(count==1){
            return true;
        }

        if(count==4 || count==16 || count==37 || count==58 || count==89 || count==145 || count==42  || count==20){
            return false;
        }
        return getKls(count);
    }
}
