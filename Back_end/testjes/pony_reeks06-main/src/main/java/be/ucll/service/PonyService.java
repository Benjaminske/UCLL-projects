package be.ucll.service;

import be.ucll.model.Pony;
import be.ucll.repository.PonyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PonyService {

    private PonyRepository ponyRepository;

    public PonyService(PonyRepository ponyRepository) {
        this.ponyRepository = ponyRepository;
    }

    public List<Pony> getAllPonies() {
        return ponyRepository.findAll();
    }

    public Optional<Pony> findPonyByName(String ponyName) {
        return ponyRepository.findByName(ponyName);
    }

//    public void addPony(Pony pony) {
//        ponyRepository.addPony(pony);
//    }
//
//    public Pony updatePony(String name, Pony newDataForExistingPony) {
//        // find pony with name name
////        Pony foundPony = findPonyByName(name);
////        if(foundPony == null)
////            throw new RuntimeException("No pony found with name " + name);
//        Pony foundPony = findPonyByName(name).orElseThrow(()->new RuntimeException("No pony found with name " + name));
////        if(foundPony == null)
////            throw new RuntimeException("No pony found with name " + name);
//        // update pony with new data found in newDataForExistingPony
//        foundPony.setName(newDataForExistingPony.getName());
//        foundPony.setAge(newDataForExistingPony.getAge());
//        return foundPony;
//    }

}
