package com.answer.model;

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
@Target(ElementType.FIELD)
public @interface Compare {
    boolean same() default false;
}
