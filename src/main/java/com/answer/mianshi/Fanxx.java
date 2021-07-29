package com.answer.mianshi;

import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * created by liufeng
 * 2021/4/13
 */
public class Fanxx implements Fanx<Map<String,Object>>{
    @Override
    public void add() {
        System.out.println(123);
    }

    public static void main(String[] args) {
        /*Fanxx fanxx=new Fanxx();
        Class cla=fanxx.getClass();
        Type type = cla.getGenericSuperclass();
        System.out.println(type);*/

       /* Map<String,Object> map=new LinkedHashMap<>();
        map.put("data",null);
        List<Map> ls= (List<Map>) map.get("data");

        for(int i=0;i<ls.size();i++){
            System.out.println(1);
        }*/

    }
}
