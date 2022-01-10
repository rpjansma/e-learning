package com.elearning.adminservice.controller.view;

import com.elearning.adminservice.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;

class ViewControllerTest {

    @Mock
    UserService userService;
    @Mock
    AdminService adminService;
    @Mock
    CourseService courseService;
    @Mock
    FeedbackService feedbackService;
    @Mock
    ContactsService contactsService;


    @Mock
    Model model;

    ViewController controller;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        controller = new ViewController(userService, adminService, contactsService , courseService, feedbackService);
    }

    @Test
    void showUserList() {
        String viewName = controller.showUserList(model);

        assertEquals(viewName, "home");
    }
}