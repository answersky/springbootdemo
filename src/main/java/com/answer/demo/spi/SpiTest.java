package com.answer.demo.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * created by liufeng
 * 2021/9/30
 */
public class SpiTest {

    public static void main(String[] args) {
        ServiceLoader<SpiService> loader=ServiceLoader.load(SpiService.class);
        for (SpiService spi:loader){
            spi.spi();
        }

    }
}
