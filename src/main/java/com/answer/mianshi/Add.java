package com.answer.mianshi;

/**
 * created by liufeng
 * 2019/1/7
 */
public class Add {
    /**
     * 请设计一个算法能够完成两个用字符串存储的整数进行相加操作，对非法的输入则返回error
     * 输入为一行，包含两个字符串，字符串的长度在[1,100]。
     * @param args
     */
    public static void main(String[] args) {
        String a="1233";
        String b="234";
        System.out.println(add(a,b));
    }

    private static String add(String a, String b) {
        //判断a，b是否合法
        char[] as=a.toCharArray();
        char[] bs=b.toCharArray();
        for(char ch:as){
            if(ch<49 || ch>57){
                System.out.println("字符串a中的"+String.valueOf(ch)+"不合法");
                return "error";
            }
        }
        for(char ch:bs){
            if(ch<49 || ch>57){
                System.out.println("字符串b中的"+String.valueOf(ch)+"不合法");
                return "error";
            }
        }
        Integer numA=Integer.parseInt(a);
        Integer numB=Integer.parseInt(b);
        Integer num=numA+numB;
        return String.valueOf(num);
    }
}
