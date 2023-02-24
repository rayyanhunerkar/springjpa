package com.rayyanhunerkar.springboot.jpahibernate.course.jdbc;

import com.rayyanhunerkar.springboot.jpahibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {
    private static final String INSERT_COURSE = """
            INSERT INTO COURSE (ID, NAME, AUTHOR) VALUES (?, ?, ?)
            """;
    private static final String DELETE_COURSE = """
            DELETE FROM COURSE WHERE ID = ?
            """;

    private static final String SELECT_COURSE_BY_ID = """
            SELECT * FROM COURSE WHERE ID = ?
            """;
    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private Course course;

    public void insert(Course course) {
        // use springJdbcTemplate to insert a record
        springJdbcTemplate.update(
                INSERT_COURSE,
                course.getId(),
                course.getName(),
                course.getAuthor()
        );
    }

    public void deleteById(Long id) {
        springJdbcTemplate.update(
                DELETE_COURSE,
                id
        );
    }

    public Course findById(Long id) {
        return springJdbcTemplate.queryForObject(
                SELECT_COURSE_BY_ID,
                new BeanPropertyRowMapper<>(Course.class),
                id
        );
    }
}
