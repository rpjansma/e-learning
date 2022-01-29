package com.elearning.controller;

import com.elearning.entity.Course;
import com.elearning.service.impl.CourseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseServiceImpl courseService;
    private String ERROR_MESSAGE = "Sorry, we got the error: ";


    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public ResponseEntity getAllCourses() {
        try {
            return new ResponseEntity(courseService.getAllCourses(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity getCourseById(@PathVariable Long id) {
        try {
            return new ResponseEntity(courseService.getCourseById(id), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity saveCourse(@RequestBody Course course) {
        try {
            return new ResponseEntity(courseService.saveCourse(course), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity updateCourse(@RequestBody Course course) {
        try {
            return new ResponseEntity<>(courseService.updateCourse(course), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return new ResponseEntity(courseService.deleteCourse(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
