package com.answer.demo.copy;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * created by liufeng
 * 2020/6/29
 */
public class test {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        AA aa=new AA();
        aa.setId(1);
        aa.setName("aa");
        aa.setTime(new Date());
        BB bb=new BB();
        BeanUtils.copyProperties(bb,aa);
        System.out.println(aa);
        System.out.println(bb);
    }
}
