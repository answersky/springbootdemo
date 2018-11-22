package com.answer.demo.jvm;

import java.util.Stack;

/**
 * created by liufeng
 * 2018/11/19
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack.push("answer");
        stack.push("123");
        stack.push("saf");
        for(int i=0;i<3;i++){
            System.out.println(stack.pop());
        }
    }
}
