package org.example.demo3.controllor;

import org.example.demo3.entity.Course;
import org.example.demo3.entity.PageResult;
import org.example.demo3.entity.Result;
import org.example.demo3.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/page")
    public Result<PageResult> page(@RequestParam(defaultValue = "1") Integer page)
    {
        PageResult pageResult = courseService.page(page);
        return Result.success(pageResult);
    }

    @PostMapping("/add")
    public void addCourse(Course course) {
        courseService.addCourse(course);
    }

    @PutMapping("/update")
    public Result<String> updateCourse(@RequestBody Course course) {
        try {
            courseService.updateCourse(course);
            return Result.success("修改课程成功");
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public Result<String> deleteCourse(@RequestBody List<String> courseNos) {
        try {
            courseService.deleteCourseByCourseNos(courseNos);
            return Result.success("删除课程成功");
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }
}
