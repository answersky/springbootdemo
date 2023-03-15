package com.answer.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Entity implements Serializable {
    private String createUser;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private String updateUser;
    private Date updateTime;
}
