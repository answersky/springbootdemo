package com.answer.mianshi;


import java.math.BigDecimal;

/**
 * created by liufeng
 * 2018/9/19
 */
public class Demo {
    public static void main(String[] args) {
        /*StringBuilder stringBuilderA=new StringBuilder("a");
        StringBuilder stringBuilderB=new StringBuilder("b");
        test(stringBuilderA,stringBuilderB);
        System.out.println(stringBuilderA);
        System.out.println(stringBuilderB);
        Integer[] integers=new Integer[2];*/

        String b="null";
        BigDecimal a=new BigDecimal(b);

    }

    private static void test(StringBuilder x,StringBuilder b){
        x.append(b);
        b=x;
    }
}
