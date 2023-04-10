package com.answer.service.mybatisplus.impl;

import cn.hutool.core.util.ObjectUtil;
import com.answer.mapper.StudentInfoMapper;
import com.answer.model.Student;
import com.answer.service.mybatisplus.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentInfoMapper, Student> implements StudentService {
    @Override
    public void addStudent(Student student) {
        student.setCreateUser("xxx");
        student.setCreateTime(new Date());
        this.baseMapper.insert(student);
    }

    @Override
    public List<Student> getAllStudents(String keyword, Integer page, Integer pageSize) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotEmpty(keyword)) {
            queryWrapper.like("username", keyword).or().like("address", keyword);
        }
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public void delStudent(List<String> ids) {
        this.baseMapper.deleteBatchIds(ids);
    }

    @Override
    public Student queryById(String id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public void updateStudent(Student student) {
        this.baseMapper.updateById(student);
    }


}
