package com.elearning.service.impl;

import com.elearning.entity.User;
import com.elearning.repository.UserRepository;
import com.elearning.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user) {
        try {
            repository.save(user);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return user;
    }

    @Override
    public Optional<User> getUserByid(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean deleteUser(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
