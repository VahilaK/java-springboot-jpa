package com.example.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
//    private List<Course> courses = new ArrayList<>(Arrays.asList(
//                            new Course("java", "Java course", "java desc"),
//                            new Course("python", "python course", "python desc"),
//                            new Course("javascript", "javascript course", "javascript desc")
//                          ));

    public List<Course> getAllCourses(String topicId){
//        return courses;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id){
//        return courses.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course) {
//        courses.add(course);
        courseRepository.save(course);
    }


    public void updateCourse(Course course ) {
        courseRepository.save(course);

    }

    public void deleteCourse(String id) {
//        courses.removeIf(t->t.getId().equals(id));
        courseRepository.deleteById(id);
        return;
    }
}
