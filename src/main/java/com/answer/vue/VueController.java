package com.answer.vue;

import com.alibaba.fastjson.JSON;
import com.answer.model.Student;
import com.answer.model.VueInfo;
import com.answer.service.mybatisplus.StudentService;
import com.answer.vue.model.Account;
import com.answer.vue.model.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vue")
@Slf4j
public class VueController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/info")
    public List<VueInfo> getInfo() {
        List<VueInfo> list = new ArrayList<>();
        VueInfo object1 = new VueInfo();
        object1.setId("01");
        object1.setTitle("打游戏");
        object1.setDone(true);
        list.add(object1);
        VueInfo object2 = new VueInfo();
        object2.setId("02");
        object2.setTitle("跳舞");
        object2.setDone(false);
        list.add(object2);
        VueInfo object3 = new VueInfo();
        object3.setId("03");
        object3.setTitle("开车");
        object3.setDone(true);
        list.add(object3);
        VueInfo object4 = new VueInfo();
        object4.setId("04");
        object4.setTitle("唱歌");
        object4.setDone(false);
        list.add(object4);
        return list;
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody Account account) {
        String username = account.getUsername();
        String password = account.getPassword();
        if (!"admin".equals(username)) {
            return ResponseResult.fail("用户名错误");
        }
        if (!"admin123".equals(password)) {
            return ResponseResult.fail("密码错误");
        }
        log.info("登陆的账号信息：" + JSON.toJSONString(account));
        String token = UUID.randomUUID() + String.valueOf(System.currentTimeMillis());
        return ResponseResult.success(token);
    }

    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public ResponseResult getAllStudents(@RequestParam("keyword") String keyword, @RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) {
        List<Student> studentList = studentService.getAllStudents(keyword, page, pageSize);
        return ResponseResult.success(studentList);
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ResponseResult addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseResult.success();
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public ResponseResult updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return ResponseResult.success();
    }

    @RequestMapping(value = "/delStudent", method = RequestMethod.GET)
    public ResponseResult delStudent(@RequestParam("ids") List<String> ids) {
        studentService.delStudent(ids);
        return ResponseResult.success();
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    public ResponseResult delStudent(@RequestParam("id") String id) {
        Student student = studentService.queryById(id);
        return ResponseResult.success(student);
    }
}
