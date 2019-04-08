package com.answer.codewars;

import static org.junit.Assert.assertEquals;

/**
 * created by liufeng
 * 2019/4/4
 */
public class FindUniq {
    private static double precision = 0.0000000000001;

    public static void main(String[] args) {
        assertEquals(1.0, findUniq(new double[]{0, 1, 0}), precision);
        assertEquals(7.0, findUniq(new double[]{6, 6, 6, 6, 6, 6,7}), precision);
    }

    public static double findUniq(double arr[]) {
        double unuiq=arr[0];
        for(int k=1;k<arr.length;k++){
            if(unuiq!=arr[k] && unuiq!=arr[k+1]){
                return unuiq;
            }
            if (unuiq != arr[k] && unuiq == arr[k+1]){
                return arr[k];
            }
            if (unuiq == arr[k] && unuiq != arr[k+1]){
                return arr[k+1];
            }
        }
        return arr[0];
    }
}
