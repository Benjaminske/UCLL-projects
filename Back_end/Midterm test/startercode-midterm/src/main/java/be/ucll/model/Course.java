package be.ucll.model;

import java.util.Objects;

public class Course {
    private int courseId;

    private String name;
    private String coordinator;
    private int credits;

    public Course(String name, int courseId, String coordinator, int credits) {
        this.name = name;
        this.courseId = courseId;
        this.coordinator = coordinator;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Course course)) return false;
        return courseId == course.courseId && credits == course.credits && Objects.equals(name, course.name) && Objects.equals(coordinator, course.coordinator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, name, coordinator, credits);
    }

}
