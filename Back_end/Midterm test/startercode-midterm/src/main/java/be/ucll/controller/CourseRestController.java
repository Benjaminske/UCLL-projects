package be.ucll.controller;

import be.ucll.model.Program;
import be.ucll.repository.CourseRepository;
import be.ucll.service.CourseService;
import be.ucll.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/courses")
public class CourseRestController {
    private final CourseService courseService;

    @Autowired
    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }
//Vraag1 a
//    @GetMapping
//    public List<Course> getAll() {
//        return courseService.getAllCourses();}
    @GetMapping
    public List<Course> getAllCourses(@RequestParam(required = false) String coordinator) {
        return courseService.getCoursesBy(coordinator);
    }

//    @PutMapping
//    public Course updateCourse(@PathVariable int courseId, @RequestBody Course course){
//        return courseService.updateCourse(courseId);
//    }
}
