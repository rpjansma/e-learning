package com.elearning.controller;

import com.elearning.entity.Feedback;
import com.elearning.service.impl.FeedbackServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/feedbacks")
@Slf4j
public class FeedbackController {

    private final FeedbackServiceImpl feedbackService;

    public FeedbackController(FeedbackServiceImpl feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/")
    public ResponseEntity getAllFeedbacks() {
        try {
            return new ResponseEntity(feedbackService.getAllFeedbacks(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got a error, try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getFeedbackById(@PathVariable Long id) {
        try {
            return new ResponseEntity(feedbackService.getFeedbackById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got a error, try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity createFeedback(@RequestBody @Valid Feedback feedback){
        try {
            return new ResponseEntity(feedbackService.saveFeedback(feedback), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got a error, try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity updateFeedback(@RequestBody @Valid Feedback feedback){
        try {
            return new ResponseEntity(feedbackService.updateFeedback(feedback), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got a error, try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFeedbackById(@PathVariable Long id) {
        try {
            return new ResponseEntity(feedbackService.deleteFeedbackById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got a error, try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
