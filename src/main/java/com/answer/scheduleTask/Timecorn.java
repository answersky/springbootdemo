package com.answer.scheduleTask;

import java.lang.annotation.*;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/6/16 9:48
 * @className: Compare
 * @packageName: com.answer.model
 * @description: 需要数据对比的注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Timecorn {
    int time() default 1000;
}
