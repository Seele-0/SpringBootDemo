package org.example.demo3.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.demo3.entity.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from student")
    List<Student> getAllStudent();

    /**
     * 按学号、姓名、班级动态查询学生信息
     *
     * @param sno       学号
     * @param name      学生姓名
     * @param className 班级
     * @return 匹配的学生列表
     */
    List<Student> getStudentByCondition(@Param("sno") String sno, @Param("name") String name, @Param("className") String className);
}
