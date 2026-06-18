package org.example.demo3.service;

import org.example.demo3.entity.Course;
import org.example.demo3.entity.PageResult;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourse();

    List<Course> getCourseByCondition(String courseNo, String courseName);

    void addCourse(Course course);

    void updateCourse(Course course);

    PageResult page(Integer page);

    void deleteCourseByCourseNos(List<String> courseNos);
}
