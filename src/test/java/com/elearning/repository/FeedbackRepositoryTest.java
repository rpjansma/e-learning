package com.elearning.repository;

import com.elearning.entity.Feedback;
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
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FeedbackRepositoryTest {

    @Autowired
    FeedbackRepository feedbackRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAllByUser() {
    }

    @Test
    void findAllFeedbacks() throws Exception {
        List<Feedback> feedbacks = feedbackRepository.findAll();

        assertEquals(1, feedbacks.size());
    }
}