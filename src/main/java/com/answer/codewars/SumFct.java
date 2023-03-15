package com.answer.codewars;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * created by liufeng
 * 2019/4/3
 */
public class SumFct {

    /**
     * 1,1,2,3,5.....
     * 前2项和 2
     * 前3项和 4 fn(3)+2
     * 前4项和 7 fn(4)+fn(3)+2
     * @param args
     */

    public static void main(String[] args) {
        assertEquals(BigInteger.valueOf(48), SumFct.perimeter(BigInteger.valueOf(5)));
        BigInteger num=func(BigInteger.valueOf(5));
        System.out.println(num);
    }

    public static BigInteger perimeter(BigInteger n) {
        BigInteger sum=BigInteger.valueOf(0);
//        n=n.add(BigInteger.ONE);
        long s=System.currentTimeMillis();
        for(BigInteger i=BigInteger.valueOf(1);i.compareTo(n)<=0;){
            System.out.println(i);
            System.out.println("==>"+func(i));
            sum=sum.add(func(i));
            i=i.add(BigInteger.valueOf(1));
        }
        System.out.println("time:"+(System.currentTimeMillis()-s));
        return sum.multiply(BigInteger.valueOf(4));
    }

    /**
     * 花费时间久
     * @param n
     * @return
     */
    private static BigInteger fn(BigInteger n){
        if(n.compareTo(BigInteger.ONE)==0 || n.compareTo(BigInteger.valueOf(2))==0){
            return BigInteger.valueOf(1);
        }
        return fn(n.subtract(BigInteger.ONE)).add(fn(n.subtract(BigInteger.valueOf(2))));
    }

    private static BigInteger func(BigInteger n){
        if(n.compareTo(BigInteger.ONE)==0 || n.compareTo(BigInteger.valueOf(2))==0){
            return BigInteger.ONE;
        }
        if(n.compareTo(BigInteger.valueOf(3))>=0){
            //数组初始化 第三位值=前两位的和
            BigInteger[] num={BigInteger.ONE,BigInteger.ONE};
            //num[0]=num[0]+num[1]; n=3---->{1,1}--->2--->{2,1}
            //num[1]=num[0]+num[1]; n=4---->{2,1}--->3--->{2,3}
            //num[0]=num[0]+num[1]; n=5---->{2,3}--->5--->{5,3}
            for(int i=2;BigInteger.valueOf(i).compareTo(n)<0;i++){
                num[i%2]=num[0].add(num[1]);
            }
            return num[(Integer.valueOf(n.toString())-1)%2];
        }
        return BigInteger.ZERO;
    }
}
