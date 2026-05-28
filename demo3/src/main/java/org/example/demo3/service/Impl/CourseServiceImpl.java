package org.example.demo3.service.Impl;

import org.example.demo3.entity.Course;
import org.example.demo3.mapper.CourseMapper;
import org.example.demo3.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getAllCourse() {
        return courseMapper.getAllCourse();
    }

    @Override
    public List<Course> getCourseByCondition(String courseNo, String courseName) {
        return courseMapper.getCourseByCondition(courseNo, courseName);
    }
}
