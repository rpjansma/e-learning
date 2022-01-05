package com.elearning.adminservice.controller.view;

import com.elearning.adminservice.entity.*;
import com.elearning.adminservice.service.impl.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ViewController {

    private final UserServiceImpl userService;
    private final AdminServiceImpl adminService;
    private final ContactsServiceImpl contactsService;
    private final CourseServiceImpl courseService;
    private final FeedbackServiceImpl feedbackService;



    public ViewController(UserServiceImpl userService, AdminServiceImpl adminService, ContactsServiceImpl contactsService, CourseServiceImpl courseService, FeedbackServiceImpl feedbackService) {
        this.userService = userService;
        this.adminService = adminService;
        this.contactsService = contactsService;
        this.courseService = courseService;
        this.feedbackService = feedbackService;
    }

    @GetMapping("/")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("admins", adminService.getAllAdmins());
        return "home";
    }

    @GetMapping("/new-user")
    public String getNewUsersPage(Model model, User user, Contacts contact) {
        model.addAttribute("users", userService.saveUser(user));
        model.addAttribute("contacts", contactsService.saveContacts(contact));
        return "add-users";
    }
    @PostMapping("/addusers")
    public String saveUser(@Valid User user, @Valid Contacts contacts, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-user";
        }


        contactsService.saveContacts(contacts);
        userService.saveUser(user);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
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
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userService.getUserByid(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.deleteUser(id);
        return "redirect:/";
    }



    @GetMapping("/new-admin")
    public String getNewAdminPage(Model model, Admin admin) {
        model.addAttribute("admins", adminService.saveAdmin(admin));
        return "add-admin";
    }
    @PostMapping("/addadmin")
    public String saveUser(@Valid Admin admin, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-admin";
        }

        adminService.saveAdmin(admin);
        return "redirect:/";
    }


    @GetMapping("/new-course")
    public String getCoursePage(Model model, Course course) {
        model.addAttribute("courses", courseService.saveCourse(course));
        return "add-course";
    }
    @PostMapping("/addcourse")
    public String saveUser(@Valid Course course, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-course";
        }

        courseService.saveCourse(course);
        return "redirect:/";
    }

    @GetMapping("/new-feedback")
    public String getFeedbackPage(Model model, Feedback feedback) {
        model.addAttribute("feedbacks", feedbackService.saveFeedback(feedback));
        return "add-feedback";
    }
    @PostMapping("/addfeedback")
    public String saveUser(@Valid Feedback feedback, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-feedback";
        }

        feedbackService.saveFeedback(feedback);
        return "redirect:/";
    }


//    @GetMapping("/new-contacts")
//    public String getContactsPage(Model model, Contacts contacts) {
//        model.addAttribute("courses", contactsService.saveContacts(contacts));
//        return "add-contacts";
//    }
//    @PostMapping("/addcontacts")
//    public String saveContacts(@Valid Contacts contacts, BindingResult result, Model model) {
//        if(result.hasErrors()) {
//            return "add-feedback";
//        }
//
//        contactsService.saveContacts(contacts);
//        return "redirect:/";
//    }
}
