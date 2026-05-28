package org.example.demo3.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.demo3.entity.Student;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student")
    List<Student> getAllStudent();

    List<Student> getStudentByCondition(String sno, String name,String className);
}
