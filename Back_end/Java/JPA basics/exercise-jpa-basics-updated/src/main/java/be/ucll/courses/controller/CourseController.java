package be.ucll.courses.controller;

import be.ucll.courses.model.Course;
import be.ucll.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseService service;

    @Autowired
    public CourseController(CourseService service){
        this.service = service;
    }

    @GetMapping
    public List<Course> getAll() {
        return service.getAll();
    }
}
