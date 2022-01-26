package com.elearning.controller;

import com.elearning.entity.User;
import com.elearning.service.integration.UserServiceApiOpenFeign;
import com.elearning.service.integration.UserServiceApiRestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/v1")
public class ExternalUserController {

    private final UserServiceApiOpenFeign userServiceApiOpenFeign;
    private final UserServiceApiRestTemplate userServiceApiRestTemplate;

    private String ERROR_MESSAGE = "Sorry, we got the error: ";

    public ExternalUserController(UserServiceApiOpenFeign userServiceApiOpenFeign, UserServiceApiRestTemplate userServiceApiRestTemplate) {
        this.userServiceApiOpenFeign = userServiceApiOpenFeign;
        this.userServiceApiRestTemplate = userServiceApiRestTemplate;
    }



    @GetMapping("/feign/users/{id}")
    public ResponseEntity getExternalUserById(@PathVariable String id) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return new ResponseEntity(userServiceApiOpenFeign.getExternalUserById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/feign/users")
    public ResponseEntity getExternalUsersFeign() {
        try {
            return new ResponseEntity(userServiceApiOpenFeign.getAllExternalUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/feign/users")
    public ResponseEntity saveUserFeign(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userServiceApiOpenFeign.createNewUser(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/rest/users")
    public ResponseEntity getExternalUsersRest() {
        try {
            return new ResponseEntity(userServiceApiRestTemplate.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/rest/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        try {
            return new ResponseEntity(userServiceApiRestTemplate.getUserById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/rest/users")
    public ResponseEntity saveUserRest(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userServiceApiRestTemplate.createNewUser(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/rest/users")
//    public ResponseEntity updateUser(@RequestBody User user) {
//        try {
//            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/rest/users/{id}")
//    public ResponseEntity deleteUser(@PathVariable Long id) {
//        try {
//            return new ResponseEntity(userService.deleteUser(id), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity("Sorry, we got a error, try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


}
