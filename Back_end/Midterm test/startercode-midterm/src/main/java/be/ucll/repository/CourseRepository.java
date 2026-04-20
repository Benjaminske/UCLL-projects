package be.ucll.repository;

import be.ucll.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public CourseRepository () {
        courses.add(new Course("Back-End Development", 999, "Steegmans", 6));
        courses.add(new Course("Back-End Development", 888, "Pieck", 6));
        courses.add(new Course("Full Stack Development", 9999, "VanImpe", 6));
        courses.add(new Course("Software Engineering", 555, "Witters", 9));
    }
    public List<Course> findAll() {
        return courses;
    }

    public List<Course> getCoursesByCoordinator(String coordinator) {
        List<Course> result = new ArrayList<>();

        for (Course course : courses) {
            if (course.getCoordinator().contains(coordinator)) {
                result.add(course);
            }
        }
        return result;
    }
//    public List<Course> getCoursesByCredits( int credits ) {
//        List<Course> result = new ArrayList<>();
//        for (Course course : program) {
//            if (course.getCredits() == credits) {
//                result.add(course);
//            }
//        }
//        return result;
//    }
//    public Course updateCourse(int courseId){
//        for(Course course : courses){
//            if(course.getCourseId() == courseId){
//               return course;
//            }
//            else{
//                throw new RuntimeException("No course with that id exists");
//            }
//        }
//    }
}
