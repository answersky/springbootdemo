package com.answer.demo.design_mode.strategy;

public class SubtractOperation implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
