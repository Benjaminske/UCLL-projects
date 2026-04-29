package be.ucll.courses.repository;

import be.ucll.courses.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    private List<Course> courses;

    public CourseRepository() {
        courses=new ArrayList<>();
        courses.add(new Course("Back-End Development", 6, 2));
        courses.add(new Course("Workplace Project Junior", 6, 3));
        courses.add(new Course("Full-Stack Development", 6, 3));
        courses.add(new Course("Workplace Project Senior", 6, 5));
        courses.add(new Course("Front-End Development", 6, 1));
    }

    public List<Course> getAll() {
        return courses;
    }
}
