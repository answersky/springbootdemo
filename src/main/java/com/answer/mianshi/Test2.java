package com.answer.mianshi;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.UUID;

/**
 * created by liufeng
 * 2021/2/22
 */
public class Test2 {
    public static void main(String[] args) {
        String uuId = UUID.randomUUID().toString();
        String timeFactor = DateFormatUtils.format(new Date(), "yyyyMMdd");
        uuId = uuId + timeFactor;
        System.out.println(uuId);
        System.out.println(uuId.hashCode());
        Integer strategyId = uuId.hashCode() & Integer.MAX_VALUE;
        System.out.println(strategyId);
        System.out.println(strategyId%100);
    }
}
