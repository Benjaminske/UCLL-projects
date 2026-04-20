package be.ucll.model;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private String name;
    private String language;
    private List<Course> courses;

    public Program (String name, String language) {
        this.name = name;
        this.language = language;
        courses = new ArrayList<>();
    }

    public void addCourse (Course course) {
        courses.add(course);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
