package com.answer.demo.spi;

/**
 * created by liufeng
 * 2021/9/30
 */
public class MyDriver implements SpiService{


    @Override
    public void spi() {
        System.out.println("MyDriver");
    }
}
