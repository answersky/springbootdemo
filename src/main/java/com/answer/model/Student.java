package com.answer.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * created by liufeng
 * 2021/10/12
 */
@Data
@TableName("student_info")
public class Student extends Entity {
    private int id;
    @Api(name = "名称")
    @Compare(same = true)
    @TableField("username")
    private String name;
    @Api(name = "年龄")
    private int age;

    private String sex;

    private String address;

    private String phone;
}
