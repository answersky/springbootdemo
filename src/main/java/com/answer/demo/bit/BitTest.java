package com.answer.demo.bit;

/**
 * created by liufeng
 * 2020/12/14
 */
public class BitTest {
    public static void main(String[] args) {
        long v=15L;
        for(int i=8;i>0;i--){
            System.out.println(v);
            System.out.println(v >> 1 << 1 != v);
            v >>= 1;
        }
    }
}
