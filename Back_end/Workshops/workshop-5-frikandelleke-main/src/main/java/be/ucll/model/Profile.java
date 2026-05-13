package be.ucll.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Role is required")
    private String role;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Interests are required")
    private String interests;

    public Profile(String role, String location, String interests) {
        setRole(role);
        setLocation(location);
        setInterests(interests);
    }

    protected Profile() {
    }

    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role == null || role.isBlank()) {
            throw new RuntimeException("Role is required");
        }
        this.role = role;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location == null || location.isBlank()) {
            throw new RuntimeException("Location is required");
        }
        this.location = location;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        if (interests == null || interests.isBlank()) {
            throw new RuntimeException("Interests are required");
        }
        this.interests = interests;
    }
}
