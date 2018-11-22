package com.answer.demo.Collection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * created by liufeng
 * 2018/11/22
 */
public class ReflectTest {
    public static void main(String[] args) {
        try {
            Method method=Class.forName("com.answer.demo.Collection.BB").getMethod("test",Integer.class);
            method.invoke(Class.forName("com.answer.demo.Collection.BB").newInstance(),1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
