package com.elearning.repository;

import com.elearning.entity.Course;
import com.elearning.entity.Feedback;
import com.elearning.entity.User;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = User.builder().user_id(1l).username("testuser").build();
    }

    @Test
    void saveNewUserAndGetItById() throws Exception {
        userRepository.save(user);
        assertEquals("testuser", userRepository.getById(1l).getUsername());
        assertEquals(1, userRepository.findAll().size());
    }

    @Test
    void deleteUser() throws Exception {
        userRepository.save(user);
        assertEquals(false, userRepository.findAll().isEmpty());
        userRepository.delete(user);
        assertEquals(true, userRepository.findAll().isEmpty());
    }


}