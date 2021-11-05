package com.answer.controller;

import com.answer.model.Student;
import com.answer.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liuf on 2021/11/5.
 */
@Controller
public class UserController {

    //student 必须有无参构造方法
    @RequestMapping(value = "/addUser",method= RequestMethod.POST)
    @ResponseBody
    public int addUser(User student){
        System.out.println(student);

        return 1;
    }
}
