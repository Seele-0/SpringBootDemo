package org.example.demo3.controllor;

import org.example.demo3.entity.Student;
import org.example.demo3.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/show")
    public List<Student> getStudents() {
        return studentMapper.getAllStudent();
    }

    @GetMapping("/search")
    public List<Student> getStudentByName(@RequestParam String name) {
        return studentMapper.getStudentByName(name);
    }
}
