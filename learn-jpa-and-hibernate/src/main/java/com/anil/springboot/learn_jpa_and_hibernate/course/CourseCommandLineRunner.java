package com.anil.springboot.learn_jpa_and_hibernate.course;

import com.anil.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.anil.springboot.learn_jpa_and_hibernate.course.springjpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        /*repository.insert(new Course(1, "Learn AWS Jpa!", "Anil Putchakayala"));
        repository.insert(new Course(2, "Learn Azure Jpa!", "Anil Putchakayala"));
        repository.insert(new Course(3, "Learn DevOps Jpa!", "Anil Putchakayala"));*/

        repository.save(new Course(1,"Learn AWS Spring JPA","Anil Putchakayala"));
        repository.save(new Course(2,"Learn Azure Spring JPA","Anil Putchakayala"));
        repository.save(new Course(3,"Learn DevOps Spring JPA","Anitha Putchakayala"));
        repository.save(new Course(4,"Learn GCP Spring JPA","Anitha Putchakayala"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));
        System.out.println("============================");
        System.out.println(repository.findAll());
        System.out.println("=============================");
        System.out.println(repository.count());
        System.out.println("==============================");
        System.out.println(repository.findByAuthor("Anitha Putchakayala"));
        System.out.println("==============================");
        System.out.println(repository.findByName("Learn Azure Spring JPA"));


    }
}
