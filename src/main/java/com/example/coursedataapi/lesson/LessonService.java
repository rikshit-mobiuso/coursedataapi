package com.example.coursedataapi.lesson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    private Logger log = LoggerFactory.getLogger(LessonService.class);


    @Autowired
    private LessonRepository lessonRepository;

//    private List<Course> topics = new ArrayList<>(Arrays.asList(
//            new Course("spring","Spring Framework","Spring Framework Description"),
//                new Course("java","Core Java","Core Java Description"),
//                new Course("javascript","JavaScript","JavaScript Description")
//        ));

    public List<Lesson> getAllLessons(String courseId) {
        List<Lesson> lessons = new ArrayList<>();
        lessonRepository.findByCourseId(courseId)
                .forEach(lessons::add);
        return lessons;
    }

    public Optional<Lesson> getLesson(String id) {
        return lessonRepository.findById(id);
    }

    public void addLesson(Lesson lesson) {
        log.info("its working");
        lessonRepository.save(lesson);
    }

    public void updateLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void deleteLesson(String id) {
        lessonRepository.deleteById(id);
    }
}
