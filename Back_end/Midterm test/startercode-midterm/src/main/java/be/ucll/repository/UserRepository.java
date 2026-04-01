package be.ucll.repository;

import be.ucll.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository () {
        User john = new User("John Doe", 25);
        User jane = new User("Jane Toe", 30);

        users.add(john);
        users.add(jane);
    }

    public List<User> findAll() {
        return users;
    }
}
