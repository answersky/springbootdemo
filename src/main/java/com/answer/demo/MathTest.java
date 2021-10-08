package com.answer.demo;

import org.assertj.core.util.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * created by liufeng
 * 2021/4/30
 */
public class MathTest {
    public static void main(String[] args) {
       BigDecimal price= new BigDecimal("77").multiply(new BigDecimal(60)).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);
        System.out.println(price);


//        List<BigDecimal> aa= Lists.newArrayList(new BigDecimal("1"),new BigDecimal("23"),null);
        List<BigDecimal> aas= new ArrayList<>();
        System.out.println(Collections.min(aas));
    }
}
