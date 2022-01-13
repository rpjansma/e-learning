package com.elearning.adminservice.entity;

import com.elearning.adminservice.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    Course course = Course.builder()
            .course_id(1L)
            .c_name("JAVA FOR BEGGINERS")
            .build();

    Admin admin = Admin.builder()
            .admin_id(1L)
            .a_name("Tester admin")
            .a_email("tester@tester.com")
            .a_password("adminPassword")
            .build();


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAdmin_id() {
        assertEquals(1l, admin.getAdmin_id());
    }

    @Test
    void getA_name() {
        assertEquals("Tester admin", admin.getA_name());
    }

    @Test
    void getA_email() {
        assertEquals("tester@tester.com", admin.getA_email());
    }

    @Test
    void getA_password() {
        assertEquals("adminPassword", admin.getA_password());
    }

    @Test
    void getCourses() {
        HashSet courses = new HashSet();
        courses.add(course);
        admin.setCourses(courses);
        assertEquals(courses, admin.getCourses());
    }
}