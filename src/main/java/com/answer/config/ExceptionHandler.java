package com.answer.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/3/22 15:26
 * @className: ExceptionHandler
 * @packageName: com.answer.config
 * @description:
 */
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception e) {
        System.out.println(e.getMessage());
        return "{\"code\":500}";
    }
}
