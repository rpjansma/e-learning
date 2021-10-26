package com.amdocs.adminservice.service;

import com.amdocs.adminservice.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    Admin saveAdmin(Admin admin);

    Admin updateAdmin(Admin admin);

    Optional<Admin> getAdminById(Long id);

    List<Admin> getAllAdmins();

    boolean deleteAdminById(Long id);

}
