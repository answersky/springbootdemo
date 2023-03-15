package com.answer.design_model.chain;

public class ChainTest {
    public static void main(String[] args) {
        ProcessChain nextChain = new Task2(null);
        ProcessChain chain = new Task1(nextChain);
        chain.doTask();
    }
}
