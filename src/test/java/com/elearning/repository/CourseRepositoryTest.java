package com.elearning.repository;

import com.elearning.entity.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@DataJpaTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAllCourses() throws Exception {


        List<Course> courses = courseRepository.findAll();
        assertEquals(0, courses.size());
    }
}