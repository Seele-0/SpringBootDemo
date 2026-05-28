package org.example.demo3.service.Impl;

import org.example.demo3.entity.Student;
import org.example.demo3.mapper.StudentMapper;
import org.example.demo3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<Student> getAllStudent() {
        return studentMapper.getAllStudent();
    }

    @Override
    public List<Student> getStudentByCondition(String sno, String name, String className) {
        return studentMapper.getStudentByCondition(sno, name, className);
    }
}
