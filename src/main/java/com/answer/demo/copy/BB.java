package com.answer.demo.copy;

import java.util.Date;

/**
 * created by liufeng
 * 2020/6/29
 */
public class BB {
    private Integer id;
    private String name;
    private Date time;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", age=" + age +
                '}';
    }
}
