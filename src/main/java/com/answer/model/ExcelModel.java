package com.answer.model;

import java.util.Date;

/**
 * @author liufeng
 * 2022/3/11 10:40
 */

public class ExcelModel {
    private String productName;
    private String requestNo;
    private String spec;

    private Integer age;

    private Date time;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ExcelModel{" +
                "productName='" + productName + '\'' +
                ", requestNo='" + requestNo + '\'' +
                ", spec='" + spec + '\'' +
                ", age=" + age +
                ", time=" + time +
                '}';
    }
}
