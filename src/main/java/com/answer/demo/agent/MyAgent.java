package com.answer.demo.agent;

import java.lang.instrument.Instrumentation;

/**
 * created by liufeng
 * 2021/8/4
 * java 探针
 */
public class MyAgent {

    public static void pre_main(String arg,Instrumentation instrumentation) {
        System.out.println("====执行pre_main方法");
        System.out.println("参数：arg="+arg);
    }
}
