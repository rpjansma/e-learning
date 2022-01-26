package com.elearning.adminservice.controller;

import com.elearning.adminservice.entity.User;
import com.elearning.adminservice.service.UserService;
import com.elearning.adminservice.service.integration.UserServiceApiOpenFeign;
import com.elearning.adminservice.service.integration.UserServiceApiRestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;
    private final UserServiceApiOpenFeign userServiceApi;
    private final UserServiceApiRestTemplate userServiceApiRestTemplate;

    public UserController(UserService userService, UserServiceApiOpenFeign userServiceApi, UserServiceApiRestTemplate userServiceApiRestTemplate) {
        this.userService = userService;
        this.userServiceApi = userServiceApi;
        this.userServiceApiRestTemplate = userServiceApiRestTemplate;
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers() {
        try {
            return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got a error, try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/feign/users/{id}")
    public ResponseEntity getExternalUserById(@PathVariable String id) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return new ResponseEntity(userServiceApi.getExternalUserById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got the error: " + e.getMessage() + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/feign/users")
    public ResponseEntity getExternalUsersFeign() {
        try {
            return new ResponseEntity(userServiceApi.getAllExternalUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Sorry, we got the error: " + e.getMessage() + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/rest/users")
    public ResponseEntity getExternalUsersRest() {
        try {
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
