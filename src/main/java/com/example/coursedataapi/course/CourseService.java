package com.example.coursedataapi.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private Logger log = LoggerFactory.getLogger(CourseService.class);


    @Autowired
    private CourseRepository courseRepository;

//    private List<Course> topics = new ArrayList<>(Arrays.asList(
//            new Course("spring","Spring Framework","Spring Framework Description"),
//                new Course("java","Core Java","Core Java Description"),
//                new Course("javascript","JavaScript","JavaScript Description")
//        ));

    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse(String id) {
        return courseRepository.findById(id);
    }

    public void addCourse(Course course) {
        log.info("its working");
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}