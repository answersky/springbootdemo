package com.answer.demo.json;

/**
 * created by liufeng
 * 2020/9/25
 */
public class StringTest {
    public static void main(String[] args) {
        String str="8353-62035-3025";
        String sellercode=str.substring(0,str.indexOf("-"));
        String spu=str.substring(str.indexOf("-")+1);
        System.out.println(sellercode);
        System.out.println(spu);
    }
}
