package com.answer.service.mybatisplus.impl;

import com.answer.mapper.StudentInfoMapper;
import com.answer.model.Student;
import com.answer.service.mybatisplus.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentInfoMapper, Student> implements StudentService {
    @Override
    public void addStudent() {
        Student student = new Student();
        student.setName("sss");
        student.setAge(23);
        student.setCreateBy("xxx");
        student.setCreateTime(new Date());
        student.setAddress("湖北省");
        student.setPhone("18576456777");
        this.baseMapper.insert(student);
    }


}
