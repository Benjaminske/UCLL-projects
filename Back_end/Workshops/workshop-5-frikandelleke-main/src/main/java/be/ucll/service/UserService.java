package be.ucll.service;

import be.ucll.model.Loan;
import be.ucll.model.Profile;
import be.ucll.model.User;
import be.ucll.repository.LoanRepository;
import be.ucll.repository.ProfileRepository;
import be.ucll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LoanRepository loanRepository;
    private final ProfileRepository profileRepository;

    @Autowired
    public UserService(UserRepository userRepository, LoanRepository loanRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.loanRepository = loanRepository;
        this.profileRepository = profileRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersByName(String name) {
        if (name == null || name.isBlank()) {
            return getAllUsers();
        }

        List<User> result = userRepository.findByName(name);
        if (result.isEmpty()) {
            throw new RuntimeException("No users found with the specified name");
        }

        return result;
    }

    public List<User> getAllAdultUsers() {
        return userRepository.findByAgeGreaterThan(17);
    }

    public List<User> getUsersBetweenAge(int min, int max) {
        if (min > max) {
            throw new RuntimeException("Minimum age cannot be greater than maximum age");
        }

        if (max - min < 0 || max - min > 150) {
            throw new RuntimeException("Invalid age range. Age must be between 0 and 150.");
        }

        return userRepository.findByAgeBetween(min, max);
    }

    public User addUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User already exists.");
        }

        if (user.getProfile() != null) {
            Profile profile = profileRepository.save(user.getProfile());
            user.setProfile(profile);
        }

        return userRepository.save(user);
    }

    public User updateUser(String email, User updatedUser) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User does not exist.");
        }

        User user = userOptional.get();

        user.setAge(updatedUser.getAge());
        user.setName(updatedUser.getName());
        user.setPassword(updatedUser.getPassword());
        user.setEmail(updatedUser.getEmail());

        return userRepository.save(user);
    }

    public void deleteUser(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User does not exist.");
        }

        User user = userOptional.get();

        List<Loan> activeLoans = loanRepository.getLoansByUser(email, true);
        if (activeLoans != null && !activeLoans.isEmpty())
            throw new RuntimeException("User has active loans.");

        loanRepository.deleteLoansByUserEmail(email);
        userRepository.delete(user);
    }

    public User getOldestUser() {
        List<User> users = userRepository.findAllByOrderByAgeDesc();

        if (users == null || users.isEmpty()) {
            throw new RuntimeException("No oldest user found.");
        }

        return users.get(0);
    }

    public Profile getUserProfile(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User does not exist.");
        }

        Profile profile = userOptional.get().getProfile();

        if (profile == null) {
            throw new RuntimeException("User has no profile.");
        }

        return profile;
    }

    public List<User> getAllUsersOlderThanAndNameContaining(int age, String name) {
        List<User> users = userRepository.findByNameContainingAndAgeGreaterThan(name, age);

        if (users == null || users.isEmpty()) {
            throw new RuntimeException("No users found older than " + age + " and containing " + name + " in their name.");
        }

        return users;
    }

    // Story 02: Retrieve users with specific interests
    public List<User> getUsersByInterests(String interests) {
        if (interests == null || interests.isBlank()) {
            throw new RuntimeException("Interests cannot be empty.");
        }

        List<User> users = userRepository.findByProfileInterestsContaining(interests);

        if (users == null || users.isEmpty()) {
            throw new RuntimeException("No users found with interests containing: " + interests);
        }

        return users;
    }

    // Story 03: Retrieve users older than a given age, with specific interests, sorted by location
    public List<User> getUsersOlderThanWithInterestsSortedByLocation(int age, String interests) {
        if (interests == null || interests.isBlank()) {
            throw new RuntimeException("Interests cannot be empty.");
        }

        List<User> users = userRepository.findByAgeGreaterThanAndProfileInterestsContainingOrderByProfileLocation(age, interests);

        if (users == null || users.isEmpty()) {
            throw new RuntimeException("No users found older than " + age + " with interests containing: " + interests);
        }

        return users;
    }
}
