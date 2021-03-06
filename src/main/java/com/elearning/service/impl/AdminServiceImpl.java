package com.elearning.service.impl;

import com.elearning.entity.Admin;
import com.elearning.repository.AdminRepository;
import com.elearning.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository repository;

    public AdminServiceImpl(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public Optional<Admin> getAdminById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return repository.findAll();
    }

    @Override
    public boolean deleteAdminById(Long id) {
        repository.deleteById(id);
        return true;
    }
}
