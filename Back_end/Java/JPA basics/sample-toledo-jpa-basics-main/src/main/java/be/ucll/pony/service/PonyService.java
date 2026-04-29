package be.ucll.pony.service;

import be.ucll.pony.model.Pony;
import be.ucll.pony.repository.PonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PonyService {

    private PonyRepository ponyRepository;

    @Autowired
    public PonyService(PonyRepository ponyRepository) {
        this.ponyRepository = ponyRepository;
    }

    public List<Pony> allPonies() {
        return ponyRepository.findAll();
    }

    public Optional<Pony> findPonyByName(String name) {
        return ponyRepository.findPonyByName(name);
    }

    public Pony addPony(Pony pony) {
        return ponyRepository.save(pony);
    }

    public Pony updatePony(String name, Pony newInformation) {
        Pony pony = findPonyByName(name).orElseThrow(() -> new RuntimeException("Pony does not exist"));
        pony.updateNameAndAge(newInformation.getName(), newInformation.getAge());
        return pony;
    }

    public void removePony(String name) {
        Pony pony = findPonyByName(name).orElseThrow(() -> new RuntimeException("Pony does not exist"));
        ponyRepository.delete(pony);
    }
}
