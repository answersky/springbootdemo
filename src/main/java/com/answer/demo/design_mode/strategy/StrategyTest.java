package com.answer.demo.design_mode.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        Context context = new Context(new AddOperation());
        int result = context.calculate(1, 2);
        System.out.println(result);

        Context context1 = new Context(new SubtractOperation());
        int result1 = context1.calculate(5, 2);
        System.out.println(result1);
    }
}
