package com.answer.service;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * created by liufeng
 * 2020/7/14
 *
 */
@Service
public class ValueAnnotateService {

    @Resource
    private Environment environment;


    public void systemValue() throws Exception {
        System.out.println("---->" + environment.getProperty("host"));
        System.out.println(environment.getProperty("answer.name"));
        throw new Exception("test Exception");
    }

}
