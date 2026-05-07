package be.ucll.repository;

import be.ucll.model.Pony;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PonyRepository2 {

    private List<Pony> ponies = new ArrayList<>();

    public PonyRepository2 () {
        reset();
    }

    public List<Pony> getPonies() {
        return ponies;
    }

    public Optional<Pony> findByName(String ponyName) {
        for(Pony pony : ponies) {
            if(pony.getName().equals(ponyName))
                return Optional.of(pony);
        }
        return Optional.empty();
    }

    public void addPony(Pony pony) {
        ponies.add(pony);
    }

    public void reset() {
        ponies.clear();

        Pony bella = new Pony("Bella", 5);
        Pony luna = new Pony("Luna", 7);

        ponies.add(bella);
        ponies.add(luna);
    }
}
