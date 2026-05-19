package com.anil.learn_spring_boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public List<Course> retrieveAllCourse(){
        return Arrays.asList(
                new Course(1, "Spring Boot", "in28Minutes"),
                new Course(2, "DevOps", "in28Minutes"),
                new Course(3, "Azure", "in28Minutes")
        );
    }
}
