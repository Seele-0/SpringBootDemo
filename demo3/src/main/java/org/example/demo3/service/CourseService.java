package org.example.demo3.service;

import org.example.demo3.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourse();

    List<Course> getCourseByCondition(String courseNo, String courseName);

    void addCourse(Course course);
}
