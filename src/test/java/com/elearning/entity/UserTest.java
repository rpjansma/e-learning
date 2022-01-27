package com.elearning.entity;

import com.elearning.repository.UserRepository;
import com.elearning.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserTest {

    User user;
    User user2;

    @Mock
    UserRepository userRepository;
    UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.userService = new UserServiceImpl(userRepository);
        user = User.builder().user_id(1L).username("batata").build();
        user2 = User.builder().username("pancake").password("password").reg_date(LocalDateTime.now()).build();
    }

    @Test
    void getUsername() {
        assertEquals("batata", user.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("password", user2.getPassword());
    }
}