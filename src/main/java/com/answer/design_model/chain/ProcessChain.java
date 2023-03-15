package com.answer.design_model.chain;

/**
 * 责任链设计模式
 */
public abstract class ProcessChain {
    ProcessChain nextChain;

    public ProcessChain(ProcessChain nextChain) {
        this.nextChain = nextChain;
    }

    public void doChain() {
        if (nextChain != null) {
            nextChain.doTask();
        } else {
            System.out.println("chain 执行完成");
        }

    }

    public abstract void doTask();
}
