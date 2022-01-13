package com.elearning.adminservice.controller;

import com.elearning.adminservice.entity.User;
import com.elearning.adminservice.service.UserService;
import com.elearning.adminservice.service.impl.UserServiceImpl;
import com.elearning.adminservice.service.integration.UserServiceApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;
    private final UserServiceApi userServiceApi;

    public UserController(UserService userService, UserServiceApi userServiceApi) {
        this.userService = userService;
        this.userServiceApi = userServiceApi;
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers() {
        try {
            return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got a error, try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/external-users/{id}")
    public ResponseEntity getExternalUserById(@PathVariable String id) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return new ResponseEntity(userServiceApi.getExternalUserById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got the error: " + e.getMessage() + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/external-users")
    public ResponseEntity getExternalUser() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return new ResponseEntity(userServiceApi.getAllExternalUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got the error: " + e.getMessage() + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/users/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        try {
            return new ResponseEntity(userService.getUserByid(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got a error, try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    public ResponseEntity saveUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got a error, try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users")
    public ResponseEntity updateUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got this error: " + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return new ResponseEntity(userService.deleteUser(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got a error, try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
