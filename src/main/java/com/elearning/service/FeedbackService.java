package com.elearning.service;

import com.elearning.entity.Feedback;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {


    Feedback saveFeedback(Feedback feedback);

    Feedback updateFeedback(Feedback feedback);

    Optional<Feedback> getFeedbackById(Long id);

    List<Feedback> getAllFeedbacks();

    boolean deleteFeedbackById(Long id);
}
