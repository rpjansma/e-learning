package com.elearning.adminservice.service.integration;

import com.elearning.adminservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8080/api/v1/users", name = "users")
public interface UserServiceApiOpenFeign {

    @GetMapping("/{id}")
    User getExternalUserById(@PathVariable String id);

    @GetMapping()
    List<User> getAllExternalUsers();
}
