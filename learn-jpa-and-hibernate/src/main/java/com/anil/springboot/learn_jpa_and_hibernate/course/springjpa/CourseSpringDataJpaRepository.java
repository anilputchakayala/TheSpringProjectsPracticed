package com.anil.springboot.learn_jpa_and_hibernate.course.springjpa;

import com.anil.springboot.learn_jpa_and_hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long> {

    List<Course> findByAuthor(String author);

    List<Course> findByName(String courseName);
}
