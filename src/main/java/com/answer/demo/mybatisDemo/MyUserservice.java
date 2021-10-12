package com.answer.demo.mybatisDemo;

import com.answer.demo.mybatisDemo.mapper.StudentMapper;
import com.answer.demo.mybatisDemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * created by liufeng
 * 2021/10/12
 */
@Service("myUserservice")
public class MyUserservice {
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;

    public void test(){
        System.out.println("执行mapper...."+userMapper);
        userMapper.test();

        studentMapper.getStudentName();
    }
}
