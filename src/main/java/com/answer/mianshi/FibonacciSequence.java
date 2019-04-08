package com.answer.mianshi;

/**
 * created by liufeng
 * 2019/1/7
 * 斐波那契数列
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        long sTime=System.currentTimeMillis();
        System.out.println(fibonacci(45));
        System.out.println("优化前花费时间："+(System.currentTimeMillis()-sTime));

        long s=System.currentTimeMillis();
        System.out.println(fibonacciOpt(40));
        System.out.println("优化后花费时间："+(System.currentTimeMillis()-s));
    }

    /**
     *黄金分割数列、兔子数列
     *F[n]=F[n-1]+F[n-2](n>=3,F[1]=1,F[2]=1)
     * 当n>40 存在耗时很长问题
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

    /**
     * 数列优化算法
     * 使用长度是2的数组代替递归计算
     * @param n
     * @return
     */
    public static long fibonacciOpt(int n){
        if(n==1 || n==2){
            return 1;
        }
        if(n>3){
            //数组初始化 第三位值=前两位的和
            long[] num={1,1};
            //num[0]=num[0]+num[1]; n=3---->{1,1}--->2--->{2,1}
            //num[1]=num[0]+num[1]; n=4---->{2,1}--->3--->{2,3}
            //num[0]=num[0]+num[1]; n=5---->{2,3}--->5--->{5,3}
            for(int i=2;i<n;i++){
                num[i%2]=num[0]+num[1];
            }
            return num[(n-1)%2];
        }
        return 0;
    }
}
