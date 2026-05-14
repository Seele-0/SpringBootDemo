package org.example.demo2.service.impl;

import cn.hutool.core.util.StrUtil;
import org.example.demo2.dao.StudentDao;
import org.example.demo2.entity.Student;
import org.example.demo2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getStudents() {
        String content = studentDao.readStudentsFile();
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
