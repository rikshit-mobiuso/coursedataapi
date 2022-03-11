package com.example.coursedataapi.lesson;

import com.example.coursedataapi.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping("/topics/{id}/courses/{courseId}/lessons")
    public List<Lesson> getAllLessons(@PathVariable String id){
        return lessonService.getAllLessons(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public Optional<Lesson> getLesson(@PathVariable String id){
        return lessonService.getLesson(id);
    }

    @PostMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public void addLesson(@RequestBody Lesson lesson, @PathVariable String courseId){
        lesson.setCourse(new Course(courseId,"","",""));
        lessonService.addLesson(lesson);
    }

    @RequestMapping(method= RequestMethod.PUT, value= "/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void updateLesson(@RequestBody Lesson lesson, @PathVariable String courseId, @PathVariable String id){
        lesson.setCourse(new Course(courseId,"","",""));
        lessonService.updateLesson(lesson);
    }

    @RequestMapping(method= RequestMethod.DELETE, value= "/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void deleteLesson(@PathVariable String id){
        lessonService.deleteLesson(id);
    }
}

