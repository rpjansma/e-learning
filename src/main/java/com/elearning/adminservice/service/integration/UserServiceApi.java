package com.elearning.adminservice.service.integration;

import com.elearning.adminservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080/api/users", name = "users")
public interface UserServiceApi {

    @GetMapping("/")
    User getAllUsers();
}
