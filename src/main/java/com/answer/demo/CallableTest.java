package com.answer.demo;

import java.util.concurrent.Callable;

/**
 * created by liufeng
 * 2018/8/24
 */
public class CallableTest implements Callable {
    private int a;
    public CallableTest(int param){
        this.a=param;
    }

    @Override
    public Object call() throws Exception {
        return 3+a;
    }
}
