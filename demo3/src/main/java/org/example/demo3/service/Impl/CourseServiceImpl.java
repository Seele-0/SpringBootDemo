package org.example.demo3.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.demo3.entity.Course;
import org.example.demo3.entity.PageResult;
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
    public void updateCourse(Course course) {
        if (course == null || course.getCourseNo() == null || course.getCourseNo().isEmpty()) {
            throw new RuntimeException("课程编号不能为空");
        }
        if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
            throw new RuntimeException("课程名称不能为空");
        }
        if (course.getClassHours() == null) {
            throw new RuntimeException("学时不能为空");
        }
        int rows = courseMapper.updateCourse(course);
        if (rows == 0) {
            throw new RuntimeException("课程不存在");
        }
    }

    @Override
    public PageResult page(Integer page) {
        int pageSize = 10;
        if (page == null || page < 1) {
            page = 1;
        }
        PageHelper.startPage(page, pageSize);
        Page<Course> courses = (Page<Course>) courseMapper.page();
        return new PageResult(courses.getTotal(), courses.getResult());
    }

    @Override
    public void deleteCourseByCourseNos(List<String> courseNos) {
        if (courseNos == null || courseNos.isEmpty()) {
            throw new RuntimeException("请选择要删除的课程");
        }
        int rows = courseMapper.deleteByCourseNos(courseNos);
        if (rows == 0) {
            throw new RuntimeException("课程不存在");
        }
    }
}
