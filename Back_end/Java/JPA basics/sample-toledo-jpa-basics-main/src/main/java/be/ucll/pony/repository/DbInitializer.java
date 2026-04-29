package be.ucll.pony.repository;

import be.ucll.pony.model.Pony;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DbInitializer {

    private PonyRepository ponyRepository;

    public DbInitializer(PonyRepository ponyRepository) {
        this.ponyRepository = ponyRepository;
    }

    @PostConstruct
    public void initialize() {
        ponyRepository.save(new Pony("Bella", 5));
        ponyRepository.save(new Pony("Luna", 7));
        ponyRepository.save(new Pony("Angel", 12));
    }
}
