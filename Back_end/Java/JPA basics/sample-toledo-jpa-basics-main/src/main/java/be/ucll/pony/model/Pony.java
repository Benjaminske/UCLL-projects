package be.ucll.pony.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.Objects;

@Entity
@Table(name = "my_ponies")
public class Pony {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name may not be empty")
    private String name;

    @Positive(message = "age must be positive")
    private int age;

    // For JPA, not public on purpose
    protected Pony() {}

    public Pony(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void updateNameAndAge(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Pony pony = (Pony) o;
        return Objects.equals(name, pony.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
