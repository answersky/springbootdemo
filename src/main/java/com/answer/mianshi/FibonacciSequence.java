package com.answer.mianshi;

/**
 * created by liufeng
 * 2019/1/7
 * 斐波那契数列
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

    /**
     *黄金分割数列、兔子数列
     *F[n]=F[n-1]+F[n-2](n>=3,F[1]=1,F[2]=1)
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if(n==1 || n==2){
            return 1;
        }
        if(n>=3){
            return fibonacci(n-2)+fibonacci(n-1);
        }
        return 0;
    }
}
