package com.example.coursedataapi.lesson;

import com.example.coursedataapi.course.Course;
import com.example.coursedataapi.topics.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lesson {
    @Id
    private String id;
    private String name;
    private String description;

    @ManyToOne
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Lesson(String id, String name, String description, String courseId) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.course = new Course(courseId,"","","");
    }

    public Lesson() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
