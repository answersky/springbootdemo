package com.answer.java8.day1;

/**
 * created by liufeng
 * 2020/8/31
 */
public class Apple {
    private String color;
    private Integer heavy;

    public Apple(String color,Integer heavy){
        this.color=color;
        this.heavy=heavy;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getHeavy() {
        return heavy;
    }

    public void setHeavy(Integer heavy) {
        this.heavy = heavy;
    }

    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getHeavy()>15;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", heavy=" + heavy +
                '}';
    }
}
