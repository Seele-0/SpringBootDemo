package org.example.demo3.controllor;

import org.example.demo3.entity.Course;
import org.example.demo3.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping("/show")
    public List<Course> getCourses() {
        return courseService.getAllCourse();
    }

    @GetMapping("/search")
    public List<Course> search(@RequestParam(required = false) String courseNo,
                               @RequestParam(required = false) String courseName) {
        return courseService.getCourseByCondition(courseNo, courseName);
    }
}
