package be.ucll.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "ponies")
public class Pony {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name may not be empty")
    private String name;

    @Positive(message = "Age must be positive")
    private int age;

    protected Pony (){

    }

    public Pony(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
//        if(age<0)
//            throw new RuntimeException("Age must be positive");
        this.age = age;
    }
}
