package com.elearning.web.controller;

import com.elearning.entity.Admin;
import com.elearning.service.impl.AdminServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admins")
@Slf4j
public class AdminController {

    private final AdminServiceImpl adminService;
    private String ERROR_MESSAGE = "Sorry, we got the error: ";


    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/")
    public ResponseEntity getAllAdmins() {
        try {
            return new ResponseEntity(adminService.getAllAdmins(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getAdminById(@PathVariable Long id) {
        try {
            return new ResponseEntity(adminService.getAdminById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity createAdmin(@RequestBody Admin admin) {
        try {
            return new ResponseEntity(adminService.saveAdmin(admin), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity updateAdmin(@RequestBody Admin admin) {
        try {
            return new ResponseEntity(adminService.updateAdmin(admin), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAdminById(@PathVariable Long id) {
        try {
            return new ResponseEntity(adminService.deleteAdminById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
