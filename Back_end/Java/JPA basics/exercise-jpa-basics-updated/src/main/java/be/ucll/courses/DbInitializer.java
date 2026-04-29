package be.ucll.courses;

import be.ucll.courses.model.Course;
import be.ucll.courses.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer implements CommandLineRunner {

    private final CourseRepository courseRepository;

    public DbInitializer(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) {
        courseRepository.save(new Course("Back-End Development", 6, 2));
        courseRepository.save(new Course("Workplace Project Junior", 6, 3));
        courseRepository.save(new Course("Full-Stack Development", 6, 3));
        courseRepository.save(new Course("Workplace Project Senior", 6, 5));
        courseRepository.save(new Course("Front-End Development", 6, 1));
    }
}
