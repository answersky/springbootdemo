package com.answer.mianshi;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * created by liufeng
 * 2019/8/2
 */
public class BeanUtilTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        M m=new M();
        m.setId(1);
        m.setName("12");
        M copyM=new M();
        M m1=new M();
        m1.setId(1);
        m1.setMsg("12");
        BeanUtils.copyProperties(copyM,m);
        System.out.println(copyM);
        BeanUtils.copyProperties(copyM,m1);
        System.out.println(copyM);
    }
}
