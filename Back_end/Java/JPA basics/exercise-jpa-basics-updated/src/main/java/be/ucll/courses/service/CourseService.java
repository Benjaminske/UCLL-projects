package be.ucll.courses.service;

import be.ucll.courses.model.Course;
import be.ucll.courses.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository=repository;
    }

    public List<Course> getAll() {
        return repository.findAll();
    }
}
