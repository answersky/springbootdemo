package com.answer.mianshi;

/**
 * created by liufeng
 * 2018/9/25
 */
public class AA {
    String a="0";
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        a.append("cccc");
        System.out.println(a);
        operator(a, b);
        System.out.println(a + "," + b);
    }
    public static void operator(StringBuffer x, StringBuffer y) {
        x.append(y); y = x;
    }

    public static int met (int i){
        return 0;
    }
}
