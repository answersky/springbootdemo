package com.answer.demo.clazz;

import com.answer.model.Api;
import com.answer.model.Student;

import java.lang.reflect.Field;

/**
 * @author liufeng
 * 2022/1/13 16:47
 */
public class Reflex {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId("1");
        student.setName("232");
        student.setAge(2);
        Field[] fields = student.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            //有的字段是用private修饰的 将他设置为可读
            fields[i].setAccessible(true);
            try {
                // 输出属性名和属性值
                System.out.println("属性名" + fields[i].getName() + "-----属性值" + fields[i].get(student));
                boolean flag = fields[i].isAnnotationPresent(Api.class);
                if (flag) {
                    Api api = fields[i].getAnnotation(Api.class);
                    System.out.println(api.name());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
}
