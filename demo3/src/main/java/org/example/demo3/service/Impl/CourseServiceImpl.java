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

    @Override
    public void addCourse(Course course) {
        //判断数据是否存在
        List<Course> list = courseMapper.getCourseByCondition(course.getCourseNo(), course.getCourseName());
        if(list != null && !list.isEmpty()){
            throw new RuntimeException("课程已存在");
        }
        courseMapper.addCourse(course);
    }

    @Override
    public void deleteCourseByCourseNo(String courseNo) {
        if (courseNo == null || courseNo.trim().isEmpty()) {
            throw new RuntimeException("课程编号不能为空");
        }
        int rows = courseMapper.deleteByCourseNo(courseNo);
        if (rows == 0) {
            throw new RuntimeException("课程不存在");
        }
    }
}
