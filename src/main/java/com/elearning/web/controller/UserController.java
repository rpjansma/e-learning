package com.elearning.web.controller;

import com.elearning.entity.User;
import com.elearning.service.UserService;
import com.elearning.web.exception.exceptions.BadRequestException;
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
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        if (id != null) return new ResponseEntity(userService.getUserByid(id), HttpStatus.OK);
        else throw new BadRequestException("Inform the userId.");
    }

    @PostMapping("/users")
    public ResponseEntity saveUser(@RequestBody User user) throws InvalidFieldException {
        if (user.isValid()) return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
        else throw new BadRequestException("Validation error, property missing or wrong.");
    }

    @PutMapping("/users")
    public ResponseEntity updateUser(@RequestBody User user) {
        if (user.isValid()) return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
        else throw new BadRequestException("Inform the userId that you want to delete.");
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        if (id != null) return new ResponseEntity(userService.deleteUser(id), HttpStatus.OK);
        else throw new BadRequestException("Inform the userId that you want to delete.");
    }

}
