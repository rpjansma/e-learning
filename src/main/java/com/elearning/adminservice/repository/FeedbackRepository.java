package com.elearning.adminservice.repository;

import com.elearning.adminservice.entity.Feedback;
import com.elearning.adminservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    Optional<Feedback> findAllByUser(User user);
}
