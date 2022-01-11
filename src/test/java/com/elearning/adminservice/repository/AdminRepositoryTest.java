package com.elearning.adminservice.repository;

import com.elearning.adminservice.entity.Admin;
import com.elearning.adminservice.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AdminRepositoryTest {

    @Autowired
    AdminRepository adminRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findAllAdmins() throws Exception {
        List<Admin> admins = adminRepository.findAll();

        assertEquals(0, admins.size());
    }
}