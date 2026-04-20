package be.ucll.service;
import be.ucll.model.Course;
import be.ucll.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public List<Course> getCoursesBy(String coordinator) {
        if (coordinator == null || coordinator.isBlank()) {
                return getAllCourses();
        };
        return courseRepository.getCoursesByCoordinator(coordinator);
    }
//    public Course updateCourse(Course courseId){
//    }

}
