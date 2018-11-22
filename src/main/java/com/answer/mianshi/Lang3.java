package com.answer.mianshi;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * created by liufeng
 * 2018/10/23
 */
public class Lang3 {
    private static Integer a;
    public static void main(String[] args) {
        System.out.println(Lang3.a);
        List<String> list=new ArrayList<>();
        if(CollectionUtils.isEmpty(list)){
            System.out.println("list is null");
        }
    }
}
