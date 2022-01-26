package com.elearning.service;

import com.elearning.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course saveCourse(Course course);

    Course updateCourse(Course course);

    Optional<Course> getCourseById(Long id);

    List<Course> getAllCourses();

    boolean deleteCourse(Long id);
}
