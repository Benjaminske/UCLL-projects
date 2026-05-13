package be.ucll.unit.repository;

import be.ucll.model.User;
import be.ucll.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class UserRepositoryStub implements UserRepository {

    public List<User> users;

    public UserRepositoryStub() {
        users = new ArrayList<>(List.of(
                new User("John Doe", 25, "john.doe@ucll.be", "john1234"),
                new User("Jane Toe", 30, "jane.toe@ucll.be", "jane1234"),
                new User("Jack Doe", 5, "jack.doe@ucll.be", "jack1234"),
                new User("Sarah Doe", 4, "sarah.doe@ucll.be", "sarah1234"),
                new User("Birgit Doe", 18, "birgit.doe@ucll.be", "birgit1234")
        ));
    }

    public void setUsers(List<User> users) {
        this.users = new ArrayList<>(users);
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean userExists(String email) {
        return users.stream().anyMatch(u -> u.getEmail().equals(email));
    }

    // --- Methods used by UserService ---

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public <S extends User> S save(S user) {
        users.removeIf(u -> u.getEmail().equals(user.getEmail()));
        users.add(user);
        return user;
    }

    @Override
    public boolean existsByEmail(String email) {
        return users.stream().anyMatch(u -> u.getEmail().equals(email));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return users.stream().filter(u -> u.getEmail().equals(email)).findFirst();
    }

    @Override
    public List<User> findByAgeGreaterThan(int age) {
        return users.stream().filter(u -> u.getAge() > age).toList();
    }

    @Override
    public List<User> findByAgeBetween(int minAge, int maxAge) {
        return users.stream().filter(u -> u.getAge() >= minAge && u.getAge() <= maxAge).toList();
    }

    @Override
    public List<User> findByName(String name) {
        return users.stream().filter(u -> u.getName().contains(name)).toList();
    }

    @Override
    public List<User> findAllByOrderByAgeDesc() {
        return users.stream().sorted((a, b) -> b.getAge() - a.getAge()).toList();
    }

    @Override
    public List<User> findByNameContainingAndAgeGreaterThan(String chars, int age) {
        return users.stream()
                .filter(u -> u.getName().contains(chars) && u.getAge() > age)
                .toList();
    }

    @Override
    public List<User> findByProfileInterestsContaining(String interests) {
        return users.stream()
                .filter(u -> u.getProfile() != null
                        && u.getProfile().getInterests().contains(interests))
                .toList();
    }

    @Override
    public List<User> findByAgeGreaterThanAndProfileInterestsContainingOrderByProfileLocation(int age, String interests) {
        return users.stream()
                .filter(u -> u.getAge() > age
                        && u.getProfile() != null
                        && u.getProfile().getInterests().contains(interests))
                .sorted((a, b) -> a.getProfile().getLocation().compareTo(b.getProfile().getLocation()))
                .toList();
    }

    @Override
    public void delete(User user) {
        users.removeIf(u -> u.getEmail().equals(user.getEmail()));
    }

    @Override
    public void deleteAll() {
        users.clear();
    }

    // --- Unused JPA boilerplate ---

    @Override public void flush() { throw new UnsupportedOperationException(); }
    @Override public <S extends User> S saveAndFlush(S entity) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) { throw new UnsupportedOperationException(); }
    @Override public void deleteAllInBatch(Iterable<User> entities) { throw new UnsupportedOperationException(); }
    @Override public void deleteAllByIdInBatch(Iterable<Long> longs) { throw new UnsupportedOperationException(); }
    @Override public void deleteAllInBatch() { throw new UnsupportedOperationException(); }
    @Override public User getOne(Long aLong) { throw new UnsupportedOperationException(); }
    @Override public User getById(Long aLong) { throw new UnsupportedOperationException(); }
    @Override public User getReferenceById(Long aLong) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> Optional<S> findOne(Example<S> example) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> List<S> findAll(Example<S> example) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> List<S> findAll(Example<S> example, Sort sort) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> long count(Example<S> example) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> boolean exists(Example<S> example) { throw new UnsupportedOperationException(); }
    @Override public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> List<S> saveAll(Iterable<S> entities) { throw new UnsupportedOperationException(); }
    @Override public Optional<User> findById(Long aLong) { throw new UnsupportedOperationException(); }
    @Override public boolean existsById(Long aLong) { throw new UnsupportedOperationException(); }
    @Override public List<User> findAllById(Iterable<Long> longs) { throw new UnsupportedOperationException(); }
    @Override public long count() { throw new UnsupportedOperationException(); }
    @Override public void deleteById(Long aLong) { throw new UnsupportedOperationException(); }
    @Override public void deleteAll(Iterable<? extends User> entities) { throw new UnsupportedOperationException(); }
    @Override public List<User> findAll(Sort sort) { throw new UnsupportedOperationException(); }
    @Override public Page<User> findAll(Pageable pageable) { throw new UnsupportedOperationException(); }
}
