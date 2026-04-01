package be.ucll.model;

import java.util.Objects;

public class User {

    private String name;
    private int age;

    public User(String name, int age) {
        setAge(age);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
