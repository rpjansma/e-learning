package com.elearning.repository;

import com.elearning.entity.Admin;
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

        Admin admin = Admin.builder().admin_id(1l).a_name("test").a_email("test@test.com").a_password("password").build();
        adminRepository.save(admin);
        assertEquals(1, admins.size());

    }
}