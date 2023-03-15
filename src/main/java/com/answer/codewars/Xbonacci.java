package com.answer.codewars;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * created by liufeng
 * 2019/3/1
 */
public class Xbonacci {
    private static double precision = 1e-10;

    public static void main(String[] args) {
//        assertArrayEquals(new double []{1,1,1,3,5,9,17,31,57,105}, tribonacci(new double []{1,1,1},10), precision);
//        assertArrayEquals(new double []{0,0,1,1,2,4,7,13,24,44}, tribonacci(new double []{0,0,1},10), precision);
//        assertArrayEquals(new double []{5,13,20,38,71,129,238,438,805,1481}, tribonacci(new double []{5,13,20},10), precision);
//        assertArrayEquals(new double []{0,12,7,19}, tribonacci(new double []{0,12,7},4), precision);
        long s=System.currentTimeMillis();
        tribonacci(new double []{5,3,2},2);
        System.out.println("花费时间："+(System.currentTimeMillis()-s));
    }

    public static double[] tribonacci(double[] s, int n) {
        if(n==0){
            double[] arr={};
            return arr;
        }

        double[] results=new double[n];
        if(n==1){
            results[0]=s[0];
        }
        if(n==2){
            results[0]=s[0];
            results[1]=s[1];
        }
        if(n==3){
            results[0]=s[0];
            results[1]=s[1];
            results[2]=s[2];
        }
        if(n>3){
            double[] three={s[0],s[1],s[2]};
            results[0]=s[0];
            results[1]=s[1];
            results[2]=s[2];
            for(int k=3;k<n;k++){
//                double result=f(k+1,three);
                double result=fast(k,results);
                results[k]=result;
            }
        }

        List<Double> list = (List<Double>) CollectionUtils.arrayToList(results);
        System.out.println(list);
        return results;
    }

    private static double fast(int i,double[] results){
        return results[i-3]+results[i-2]+results[i-1];
    }

    private static double f(int i,double[] arr) {
        if(i==1){
            return arr[0];
        }
        if(i==2){
            return arr[1];
        }
        if(i==3){
            return arr[2];
        }
        return f(i-1,arr)+f(i-2,arr)+f(i-3,arr);
    }
}
