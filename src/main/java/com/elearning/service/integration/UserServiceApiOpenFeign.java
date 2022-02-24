package com.elearning.service.integration;

import com.elearning.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(url = "http://localhost:8080/api/v1/users", name = "users")
public interface UserServiceApiOpenFeign {

    @GetMapping("/{id}")
    User getExternalUserById(@PathVariable Long id);

    @GetMapping()
    List<User> getAllUsers();

    @PostMapping()
    List<User> createNewUser(@RequestBody User user);
}
