package com.answer.design_model.chain;

public class Task1 extends ProcessChain {
    public Task1(ProcessChain chain) {
        super(chain);
    }

    public void doTask() {
        System.out.println("task1 执行。。。。。");
        super.doChain();
    }
}
