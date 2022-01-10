package com.elearning.adminservice.entity;

import com.elearning.adminservice.repository.UserRepository;
import com.elearning.adminservice.service.impl.UserServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserTest {

    User user = User.builder().user_id(1L).username("batata").build();
    User user2 = User.builder().username("pancake").build();
    @Mock
    UserRepository userRepository;
    UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.userService = new UserServiceImpl(userRepository);
    }

    @Test
    void getUsername() {
        assertEquals("batata", user.getUsername());
        when(userService.saveUser(user)).thenReturn(user);
    }

    @Test
    void getPassword() {
    }

    @Test
    void getCourse() {
    }

    @Test
    void getContacts() {
    }

    @Test
    void getFeedbacks() {
    }

    @Test
    void setUsername() {
    }

    @Test
    void setPassword() {
    }

    @Test
    void setCourse() {
    }

    @Test
    void setContacts() {
    }

    @Test
    void setFeedbacks() {
    }
}