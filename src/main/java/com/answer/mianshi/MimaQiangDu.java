package com.answer.mianshi;

import java.util.Scanner;

/**
 * created by liufeng
 * 2019/1/10
 */
public class MimaQiangDu {
    /**
     * 牛牛选择了一个正整数X,然后把它写在黑板上。然后每一天他会擦掉当前数字的最后一位,直到他擦掉所有数位。
     * 在整个过程中,牛牛会把所有在黑板上出现过的数字记录下来,然后求出他们的总和sum.
     * 例如X = 509, 在黑板上出现过的数字依次是509, 50, 5, 他们的和就是564.
     * 牛牛现在给出一个sum,牛牛想让你求出一个正整数X经过上述过程的结果是sum.
     * 正整数sum(1 ≤ sum ≤ 10^18)
     * @param args
     */

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String num=scanner.nextLine();
        validatePassword(num);
    }

    private static Long count=0L;
    private static void validatePassword(String num) {
        try {
            long n=Long.parseLong(num);
            if(n<1 || n>(Math.pow(10,18))){
                System.out.println(-1);
            }else {
                count=n;
                cachu(num);
                System.out.println(count);
            }
        } catch (NumberFormatException e) {
            //转换失败 说明输入的不是数字
            System.out.println(-1);
            e.printStackTrace();
        }

    }


    //每次擦掉个位数
    private static void cachu(String num) {
        if(num.length()>1){
            num=num.substring(0,num.length()-1);
            System.out.println(num);
            count+=Long.parseLong(num);
            cachu(num);
        }
    }
}
