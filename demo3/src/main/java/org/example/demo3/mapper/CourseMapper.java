package org.example.demo3.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.demo3.entity.Course;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select("select * from course")
    List<Course> getAllCourse();

    List<Course> getCourseByCondition(@Param("courseNo") String courseNo, @Param("courseName") String courseName);
}
