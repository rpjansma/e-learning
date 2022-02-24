package com.elearning.web.controller.view;

import com.elearning.entity.*;
import com.elearning.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ViewController {

    private final UserService userService;
    private final AdminService adminService;
    private final ContactsService contactsService;
    private final CourseService courseService;
    private final FeedbackService feedbackService;


    public ViewController(UserService userService, AdminService adminService, ContactsService contactsService, CourseService courseService, FeedbackService feedbackService) {
        this.userService = userService;
        this.adminService = adminService;
        this.contactsService = contactsService;
        this.courseService = courseService;
        this.feedbackService = feedbackService;
    }

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("admins", adminService.getAllAdmins());
        return "home";
    }

    @GetMapping("/new-user")
    public String getNewUsersPage(Model model, User user) {
        model.addAttribute("users", user);
        return "add-users";
    }

    @PostMapping("/addusers")
    public String saveUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String getUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.getUserByid(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setUser_id(id);
            return "update-user";
        }

        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


    @GetMapping("/new-admin")
    public String getNewAdminPage(Model model, Admin admin) {
        model.addAttribute("admins", admin);
        return "add-admin";
    }

    @PostMapping("/addadmin")
    public String saveUser(@Valid Admin admin, BindingResult result) {
        if (result.hasErrors()) {
            return "add-admin";
        }

        adminService.saveAdmin(admin);
        return "redirect:/";
    }


    @GetMapping("/new-course")
    public String getCoursePage(Model model, Course course) {
        model.addAttribute("courses", course);
        return "add-course";
    }

    @PostMapping("/addcourse")
    public String saveUser(@Valid Course course, BindingResult result) {
        if (result.hasErrors()) {
            return "add-course";
        }

        courseService.saveCourse(course);
        return "redirect:/";
    }

    @GetMapping("/new-feedback")
    public String getFeedbackPage(Model model, Feedback feedback) {
        model.addAttribute("feedbacks", feedback);
        return "add-feedback";
    }

    @PostMapping("/addfeedback")
    public String saveUser(@Valid Feedback feedback, BindingResult result) {
        if (result.hasErrors()) {
            return "add-feedback";
        }

        feedbackService.saveFeedback(feedback);
        return "redirect:/";
    }


    @GetMapping("/new-contacts")
    public String getContactsPage(Model model, Contacts contacts) {
        model.addAttribute("courses", contactsService.saveContacts(contacts));
        return "add-contacts";
    }
    @PostMapping("/addcontacts")
    public String saveContacts(@Valid Contacts contacts, BindingResult result) {
        if(result.hasErrors()) {
            return "add-feedback";
        }

        contactsService.saveContacts(contacts);
        return "redirect:/";
    }
}
