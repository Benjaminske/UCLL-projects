package be.ucll;

import be.ucll.model.Program;
import be.ucll.repository.CourseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    CourseRepository courseRepository = new CourseRepository();
    Program TI = new Program("TI", "Nederlands");

}
