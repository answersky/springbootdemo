package com.answer.demo.copy;

import java.math.BigDecimal;
import java.util.Date;

/**
 * created by liufeng
 * 2020/6/29
 */
public class AA {
    private Integer id;
    private String name;
    private Date time;
    private BigDecimal price;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", price=" + price +
                '}';
    }
}
