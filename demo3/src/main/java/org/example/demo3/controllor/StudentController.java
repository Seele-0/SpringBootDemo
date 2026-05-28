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

    /**
     * 查询所有学生信息
     *
     * @return 所有学生列表
     */
    @GetMapping("/show")
    public List<Student> getStudents() {
        return studentMapper.getAllStudent();
    }

    /**
     * 按学号、姓名、班级动态查询学生信息
     *
     * @param sno       学号
     * @param name      学生姓名
     * @param className 班级
     * @return 匹配的学生列表
     */
    @GetMapping("/search")
    public List<Student> search(@RequestParam(required = false) String sno,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String className) {
        return studentMapper.getStudentByCondition(sno, name, className);
    }
}
