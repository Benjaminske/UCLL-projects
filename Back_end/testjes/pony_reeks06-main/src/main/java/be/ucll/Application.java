package be.ucll;

import be.ucll.controller.PonyController;
import be.ucll.repository.PonyRepository;
import be.ucll.service.PonyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
