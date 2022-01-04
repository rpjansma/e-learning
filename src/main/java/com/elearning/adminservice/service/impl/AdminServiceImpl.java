package com.elearning.adminservice.service.impl;

import com.elearning.adminservice.entity.Admin;
import com.elearning.adminservice.repository.AdminRepository;
import com.elearning.adminservice.service.AdminService;
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
