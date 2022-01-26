package com.elearning.adminservice.service.integration;

import com.elearning.adminservice.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceApiRestTemplate {

    RestTemplate restTemplate = new RestTemplate();
    String usersServiceUrl = "http://localhost:8080/api/v1/users";
    List<User> getAllUsers() {
        return restTemplate.getForObject(usersServiceUrl, List.class);
    }

}
