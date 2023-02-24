package com.rayyanhunerkar.springboot.jpahibernate.course;

import com.rayyanhunerkar.springboot.jpahibernate.course.springjpa.CourseSpringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJDBCRepository courseJDBCRepository;

//    @Autowired
//    CourseJPARepository repository;

    @Autowired
    private CourseSpringRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1001L, "Spring Boot", "Rayyan Hunerkar"));
        repository.save(new Course(1002L, "Quarkus", "Rayyan Hunerkar"));
        repository.save(new Course(1003L, "React", "Rayyan Hunerkar"));
        repository.deleteById(1003L);

        System.out.println(repository.findById(1001L));
        System.out.println(repository.findById(1002L));

        repository.findByAuthor("Rayyan Hunerkar").forEach(System.out::println);
        repository.findByName("Spring Boot").forEach(System.out::println);

    }
}
