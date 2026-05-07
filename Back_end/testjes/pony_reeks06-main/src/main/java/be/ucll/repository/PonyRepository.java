package be.ucll.repository;

import be.ucll.model.Pony;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PonyRepository extends JpaRepository<Pony, Long> {
    Optional<Pony> findByName(String name);
}
