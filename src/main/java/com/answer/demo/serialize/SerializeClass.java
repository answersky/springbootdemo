package com.answer.demo.serialize;

import java.io.Serializable;

/**
 * created by liufeng
 * 2020/8/21
 */
public class SerializeClass implements Serializable {
    private static final long serialVersionUID = 3931122559585553848L;
    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "SerializeClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
