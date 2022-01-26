package com.elearning.service.integration;

import com.elearning.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceApiRestTemplate {

    RestTemplate restTemplate = new RestTemplate();
    String usersServiceUrl = "http://localhost:8080/api/v1/users";

    public List<User> getAllUsers() {
        return restTemplate.getForObject(usersServiceUrl, List.class);
    }

    public User getUserById(Long id) {
        return restTemplate.getForObject(usersServiceUrl + "/" + id, User.class);
    }

    public ResponseEntity<User> createNewUser(User user) {
        return restTemplate.postForEntity(usersServiceUrl, user, User.class);
}

//    public ResponseEntity<User> deleteUserById(Long id) {
//        return restTemplate.de(usersServiceUrl, id, User.class);
//    }



}
