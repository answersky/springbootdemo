package com.answer.utlis;

import cn.hutool.core.util.ObjectUtil;
import com.answer.model.Compare;
import com.answer.model.Student;

import java.lang.reflect.Field;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/6/16 9:51
 * @className: CompareUtil
 * @packageName: com.answer.utlis
 * @description:
 */
public class CompareUtil {

    public static void main(String[] args) throws Exception {
        Student s1 = new Student(1, "张三", 22);
        Student s2 = new Student(1, "张三1", 23);
        boolean flag = compareObject(s1, s2);
        System.out.println("是否相同：" + flag);
    }

    private static boolean compareObject(Object originalObject, Object targetObject) throws Exception {
        //默认没有修改
        boolean compareFlag = true;
        //获取目标类中所有的字段
        Field[] fieldArrays = originalObject.getClass().getDeclaredFields();
        for (int i = 0; i < fieldArrays.length; i++) {
            fieldArrays[i].setAccessible(true);
            Field field = fieldArrays[i];
            //获取字段上的注解
            Compare compare = field.getAnnotation(Compare.class);
            //判断存在@compare注解的并且值是true才需要进行比较
            if (ObjectUtil.isNotEmpty(compare)) {
                boolean flag = compare.same();
                if (flag) {
                    //跟目标类中的相同字段比较
                    String fileName = field.getName();
                    Object fieldValue = field.get(originalObject);
                    //通过属性名称获取属性
                    Field targetField = targetObject.getClass().getDeclaredField(fileName);
                    targetField.setAccessible(true);
                    Object targetValue = targetField.get(targetObject);

                    if (!fieldValue.equals(targetValue)) {
                        //字段值一样
                        compareFlag = false;
                        break;
                    }

                }
            }

        }
        return compareFlag;

    }
}
