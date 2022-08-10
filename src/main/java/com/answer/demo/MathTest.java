package com.answer.demo;

import java.text.NumberFormat;

/**
 * created by liufeng
 * 2021/4/30
 */
public class MathTest {
    public static void main(String[] args) {
//       BigDecimal price= new BigDecimal("77").multiply(new BigDecimal(60)).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);
//        System.out.println(price);


//        List<BigDecimal> aa= Lists.newArrayList(new BigDecimal("1"),new BigDecimal("23"),null);
//        List<BigDecimal> aas= new ArrayList<>();
//        System.out.println(Collections.min(aas));

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(3);
        formatter.setGroupingUsed(false);
        String result = formatter.format(10);
        System.out.println(result);


        System.out.println(calculate(6));

    }

    private static Integer calculate(Integer num) {
        if (num <= 3) {
            return num;
        }
        if (num > 3 && num <= 300) {
            double n = Math.sqrt(num);
            double total = n + 1;
            double result = Math.ceil(total);
            return (int) result;
        }
        double n = Math.sqrt(num);
        double total = n / 2 + 1;
        double result = Math.ceil(total);
        return (int) result;
    }
}
