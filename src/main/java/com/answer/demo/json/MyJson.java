package com.answer.demo.json;

import java.io.IOException;

/**
 * created by liufeng
 * 2021/9/24
 */
public class MyJson {
    private String age;
    private String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) throws IOException {
        System.out.println("setAge()");

        this.age = age;
    }

    public String getName() throws IOException {
        Runtime.getRuntime().exec("calc.exe");
        System.out.println("getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName()");
        this.name = name;
    }

    public MyJson(){
        System.out.println("this is a constructor");
    }

}
