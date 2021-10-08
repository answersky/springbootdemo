package com.answer.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * created by liufeng
 * 2021/9/1
 */
public class dumpTest {

    public static void main(String[] args) {
        List<Dump> list=new ArrayList<>();
        int i=0;
        while (true){
            Dump dump=new Dump();
            i++;
            list.add(dump);
            System.out.println("add ="+i+"");
        }
    }
}
