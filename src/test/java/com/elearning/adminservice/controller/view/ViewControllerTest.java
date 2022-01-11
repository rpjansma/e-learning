package com.elearning.adminservice.controller.view;

import com.elearning.adminservice.entity.*;
import com.elearning.adminservice.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;

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

    Contacts contacts = Contacts.builder()
            .contact_id(1L)
            .fullName("Tester testing")
            .email("test@test.com")
            .phoneNumber("016123321212")
            .build();

    Course course = Course.builder()
            .course_id(1L)
            .c_name("JAVA FOR BEGGINERS")
            .build();

    Feedback feedback = Feedback.builder()
            .feedback_id(1L)
            .build();

    HashSet feedbacks = new HashSet();

    User user = User.builder()
            .user_id(1L)
            .username("testing test")
            .password("password111")
            .build();

    Admin admin = Admin.builder()
            .admin_id(1L)
            .a_name("Tester admin")
            .a_email("tester@tester.com")
            .a_password("adminPassword")
            .build();

    ViewController viewController;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        viewController = new ViewController(userService, adminService, contactsService, courseService, feedbackService);

        user.setContacts(contacts);
        user.setCourse(course);
        feedbacks.add(feedback);
        user.setFeedbacks(feedbacks);
        admin.setCourses(course);
    }

    @Test
    void getIndexPage() {
        String viewName = viewController.getIndexPage(model);
        assertEquals(viewName, "home");
    }

    @Test
    void getNewUsersPage() {
        String viewName = viewController.getNewUsersPage(model, user, contacts);
        assertEquals(viewName, "add-users");
    }

    @Test
    void getUpdateForm() {
//        String viewName = viewController.getNewUsersPage(model, user, contacts);
//        assertEquals(viewName, "update-user");
    }

    @Test
    void getNewAdminPage() {
        String viewName = viewController.getNewAdminPage(model,admin);
        assertEquals(viewName, "add-admin");
    }

    @Test
    void getCoursePage() {
        String viewName = viewController.getCoursePage(model,course);
        assertEquals(viewName, "add-course");
    }

    @Test
    void getFeedbackPage() {
        String viewName = viewController.getFeedbackPage(model,feedback);
        assertEquals(viewName, "add-feedback");
    }
}