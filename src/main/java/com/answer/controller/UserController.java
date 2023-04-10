package com.answer.controller;

import com.answer.model.Student;
import com.answer.service.mybatisplus.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuf on 2021/11/5.
 */
@RestController
@RequestMapping("/student")
public class UserController {
    @Autowired
    private StudentService studentService;

    //student 必须有无参构造方法
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public int addUser() {
        studentService.addStudent(new Student());
        return 1;
    }


}
