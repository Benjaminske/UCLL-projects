package be.ucll.repository;

import be.ucll.model.Pony;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer {

    private PonyRepository ponyRepository;

    public DBInitializer(PonyRepository ponyRepository) {
        this.ponyRepository = ponyRepository;
    }

    @PostConstruct
    public void intialize() {
        ponyRepository.save(new Pony("Bella", 5));
        ponyRepository.save(new Pony("Luna", 7));
    }
}
