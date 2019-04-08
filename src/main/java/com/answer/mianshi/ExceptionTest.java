package com.answer.mianshi;

/**
 * created by liufeng
 * 2019/4/3
 */
public class ExceptionTest {
    public static void main(String[] args) {
        float a= (float) (2.0/0);
        System.out.println(a);

        try {
//            int b=2/0;
//            System.out.println(b);
            float c= (float) (0.0/0);
            System.out.println(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
