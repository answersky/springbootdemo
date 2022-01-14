package com.answer.model;

import java.lang.annotation.*;

/**
 * @author liufeng
 * 2022/1/13 17:06
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Api {
    String name() default "";
}
