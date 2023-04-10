package com.answer.service.mybatisplus;


import com.answer.model.Student;

import java.util.List;

public interface StudentService {

   void addStudent(Student student);

   List<Student> getAllStudents(String keyword, Integer page, Integer pageSize);

   void delStudent(List<String> ids);

   Student queryById(String id);

   void updateStudent(Student student);
}
