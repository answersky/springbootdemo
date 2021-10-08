package com.answer.demo.spi;

/**
 * created by liufeng
 * 2021/9/30
 */
public class MySpi implements SpiService{
    @Override
    public void spi() {
        System.out.println("MySpi");
    }
}
