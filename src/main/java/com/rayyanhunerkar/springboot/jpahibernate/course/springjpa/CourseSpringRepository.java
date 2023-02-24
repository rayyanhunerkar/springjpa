package com.rayyanhunerkar.springboot.jpahibernate.course.springjpa;

import com.rayyanhunerkar.springboot.jpahibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringRepository extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);

    List<Course> findByName(String name);

}

