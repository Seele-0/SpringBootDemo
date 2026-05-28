package org.example.demo3.controllor;

import org.example.demo3.entity.Student;
import org.example.demo3.service.StudentService;
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
    private StudentService studentService;


    @GetMapping("/show")
    public List<Student> getStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam(required = false) String sno,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String className) {
        return studentService.getStudentByCondition(sno, name, className);
    }
}
