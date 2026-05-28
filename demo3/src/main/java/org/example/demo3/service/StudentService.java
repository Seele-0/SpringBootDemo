package org.example.demo3.service;

import org.example.demo3.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    List<Student> getStudentByCondition(String sno, String name, String className);
}
