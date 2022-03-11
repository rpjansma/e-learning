package com.elearning.web.controller;

import com.elearning.entity.Feedback;
import com.elearning.service.impl.FeedbackServiceImpl;
import com.elearning.web.exception.exceptions.BadRequestException;
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
    private String ERROR_MESSAGE = "Sorry, we got the error: ";


    public FeedbackController(FeedbackServiceImpl feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/")
    public ResponseEntity getAllFeedbacks() {
        return new ResponseEntity(feedbackService.getAllFeedbacks(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity getFeedbackById(@PathVariable Long id) {
        if (id != null) return new ResponseEntity(feedbackService.getFeedbackById(id), HttpStatus.OK);
        else throw new BadRequestException("Inform the userId.");
    }

    @PostMapping("/")
    public ResponseEntity createFeedback(@RequestBody @Valid Feedback feedback) {
        if (feedback.isValid()) return new ResponseEntity(feedbackService.saveFeedback(feedback), HttpStatus.CREATED);
        else throw new BadRequestException("Validation error, property missing or wrong.");
    }

    @PutMapping("/")
    public ResponseEntity updateFeedback(@RequestBody @Valid Feedback feedback) {
        if (feedback.isValid()) return new ResponseEntity(feedbackService.saveFeedback(feedback), HttpStatus.CREATED);
        else throw new BadRequestException("Validation error, property missing or wrong.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFeedbackById(@PathVariable Long id) {
        if (id != null) return new ResponseEntity(feedbackService.deleteFeedbackById(id), HttpStatus.OK);
        else throw new BadRequestException("Inform the feedback ID that you want to delete.");
    }

}
