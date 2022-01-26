package com.elearning.service.impl;

import com.elearning.entity.Course;
import com.elearning.repository.CourseRepository;
import com.elearning.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @Override
    public boolean deleteCourse(Long id) {
        repository.deleteById(id);
        return true;
    }
}
