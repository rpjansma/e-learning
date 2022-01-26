package com.elearning.controller;

import com.elearning.service.UserService;
import com.elearning.service.integration.UserServiceApiOpenFeign;
import com.elearning.service.integration.UserServiceApiRestTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {

    @Mock
    UserService userService;

    @Mock
    UserServiceApiOpenFeign userServiceApi;

    @Mock
    UserServiceApiRestTemplate userServiceApiRest;

    UserController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new UserController(userService, userServiceApi, userServiceApiRest);
    }

    @Test
    void getAllUsers() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/api/v1/users/")).andExpect(status().isOk());
    }

    @Test
    void getExternalUserById() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();


        mockMvc.perform(get("/api/v1/users/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user").exists());
    }

    @Test
    void getExternalUser() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void saveUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}