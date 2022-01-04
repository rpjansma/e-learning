package com.elearning.adminservice.service.impl;

import com.elearning.adminservice.entity.Feedback;
import com.elearning.adminservice.repository.FeedbackRepository;
import com.elearning.adminservice.service.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository repository;

    public FeedbackServiceImpl(FeedbackRepository repository) {
        this.repository = repository;
    }

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return repository.save(feedback);
    }

    @Override
    public Feedback updateFeedback(Feedback feedback) {
        return repository.save(feedback);
    }

    @Override
    public Optional<Feedback> getFeedbackById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return repository.findAll();
    }

    @Override
    public boolean deleteFeedbackById(Long id) {
        repository.deleteById(id);
        return true;
    }
}
