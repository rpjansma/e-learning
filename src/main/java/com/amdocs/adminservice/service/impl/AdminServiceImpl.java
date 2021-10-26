package com.amdocs.adminservice.service.impl;

import com.amdocs.adminservice.entity.Admin;
import com.amdocs.adminservice.repository.AdminRepository;
import com.amdocs.adminservice.service.AdminService;
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
