package be.ucll.pony.repository;

import be.ucll.pony.model.Pony;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PonyRepository extends JpaRepository<Pony, Long> {

    Optional<Pony> findPonyByName(String name);
}


