package com.answer.mianshi;

/**
 * created by liufeng
 * 2019/1/7
 * 青蛙跳台阶
 */
public class QingwaTiao {
    /**
     * 青蛙可以一次跳一个台阶，也可以一次跳2个台阶
     * @param args
     */
    public static void main(String[] args) {
        int num=jumpFloor(6);
        System.out.println(num);
    }

    /**
     * 1:1 （1）
     * 2:1+1;2 （2）
     * 3:1+1+1;1+2;2+1 (3)
     * 4:1+1+1+1;1+2+1;1+1+2;2+1+1;2+2 (5)
     * 5:1+1+1+1+1;1+1+1+2;1+1+2+1;1+2+1+1;1+2+2;2+1+1+1;2+1+2;2+2+1  (8)
     * f(1)=1;f(2)=2;f(3)=f(1)+f(2);....n>=3====>f(n)=f(n-2)+f(n-1)
     * @param floorNum
     * @return
     */
    private static int jumpFloor(int floorNum){
        if(floorNum==1){
            return 1;
        }
        if(floorNum==2){
            return 2;
        }
        if(floorNum>=3){
            return jumpFloor(floorNum-2)+jumpFloor(floorNum-1);
        }
        return 0;
    }
}
