package org.example.demo1.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import org.example.demo1.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @GetMapping("/show")
    public List<Student> getStudents() {
        String content = FileUtil.readUtf8String("classpath:static/students.txt");
        List<String> lines = StrUtil.split(content, '\n');
        List<Student> students = new ArrayList<>();
        for (String line : lines) {
            if (StrUtil.isBlank(line)) {
                continue;
            }
            String[] parts = line.split(",");
            students.add(new Student(parts[0], parts[1], parts[2], parts[3], parts[4]));
        }
        return students;
    }
}
