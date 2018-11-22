package com.answer.mianshi;



import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * created by liufeng
 * 2018/9/19
 */
public class Demo {
    public static void main(String[] args) {
        StringBuilder stringBuilderA=new StringBuilder("a");
        StringBuilder stringBuilderB=new StringBuilder("b");
        test(stringBuilderA,stringBuilderB);
        System.out.println(stringBuilderA);
        System.out.println(stringBuilderB);
    }

    private static void test(StringBuilder x,StringBuilder b){
        x.append(b);
        b=x;
    }
}
