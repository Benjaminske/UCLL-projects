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

    private List<User> users;

    public UserRepositoryStub() {
        users = new ArrayList<>(List.of(
                new User("John Doe", 25, "john.doe@ucll.be", "john1234"),
                new User("Jane Toe", 30, "jane.toe@ucll.be", "jane1234"),
                new User("Jack Doe", 5, "jack.doe@ucll.be", "jack1234"),
                new User("Sarah Doe", 4, "sarah.doe@ucll.be", "sarah1234"),
                new User("Birgit Doe", 18, "birgit.doe@ucll.be", "birgit1234")
        ));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public <S extends User> S save(S entity) {
        users.add(entity);
        return entity;
    }

    @Override
    public boolean existsByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> findByAgeGreaterThan(int age) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getAge() >= age) {
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public List<User> findByAgeBetween(int minAge, int maxAge) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getAge() >= minAge && user.getAge() <= maxAge) {
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getName().contains(name)) {
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public void delete(User entity) {
        users.removeIf(u -> u.getEmail().equals(entity.getEmail()));
    }

    @Override
    public List<User> findAllByOrderByAgeDesc() {
        return users.stream()
                .sorted((a, b) -> Integer.compare(b.getAge(), a.getAge()))
                .toList();
    }

    @Override
    public List<User> findByNameContainingAndAgeGreaterThan(String chars, int age) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getName().contains(chars) && user.getAge() > age) {
                result.add(user);
            }
        }
        return result;
    }


    @Override
    public void flush() {}

    @Override
    public <S extends User> S saveAndFlush(S entity) { return null; }

    @Override
    public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) { return List.of(); }

    @Override
    public void deleteAllInBatch(Iterable<User> entities) {}

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {}

    @Override
    public void deleteAllInBatch() {}

    @Override
    public User getOne(Long aLong) { return null; }

    @Override
    public User getById(Long aLong) { return null; }

    @Override
    public User getReferenceById(Long aLong) { return null; }

    @Override
    public <S extends User> Optional<S> findOne(Example<S> example) { return Optional.empty(); }

    @Override
    public <S extends User> List<S> findAll(Example<S> example) { return List.of(); }

    @Override
    public <S extends User> List<S> findAll(Example<S> example, Sort sort) { return List.of(); }

    @Override
    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) { return null; }

    @Override
    public <S extends User> long count(Example<S> example) { return 0; }

    @Override
    public <S extends User> boolean exists(Example<S> example) { return false; }

    @Override
    public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) { return null; }

    @Override
    public <S extends User> List<S> saveAll(Iterable<S> entities) { return List.of(); }

    @Override
    public Optional<User> findById(Long aLong) { return Optional.empty(); }

    @Override
    public boolean existsById(Long aLong) { return false; }

    @Override
    public List<User> findAllById(Iterable<Long> longs) { return List.of(); }

    @Override
    public long count() { return 0; }

    @Override
    public void deleteById(Long aLong) {}

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {}

    @Override
    public void deleteAll(Iterable<? extends User> entities) {}

    @Override
    public void deleteAll() {}

    @Override
    public List<User> findAll(Sort sort) { return List.of(); }

    @Override
    public Page<User> findAll(Pageable pageable) { return null; }
}
