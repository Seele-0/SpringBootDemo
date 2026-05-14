package org.example.demo2.controller;

import org.example.demo2.entity.Student;
import org.example.demo2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/show")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
