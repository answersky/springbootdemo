package com.answer.design_model.chain;

public class Task2 extends ProcessChain {
    public Task2(ProcessChain chain) {
        super(chain);
    }

    public void doTask() {
        System.out.println("task2 执行。。。。。");
        super.doChain();
    }
}
