package com.elearning.web.controller;

import com.elearning.entity.User;
import com.elearning.service.UserService;
import com.elearning.web.exception.exceptions.InvalidFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;
    private String ERROR_MESSAGE = "Sorry, we got the error: ";


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers() {
        try {
            return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/users/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        try {
            return new ResponseEntity(userService.getUserByid(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    public ResponseEntity saveUser(@RequestBody User user) throws InvalidFieldException {
            if(user.isValid()) return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
            else throw new InvalidFieldException("Validation error, check the user data.");
    }

    @PutMapping("/users")
    public ResponseEntity updateUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return new ResponseEntity(userService.deleteUser(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}