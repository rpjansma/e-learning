package com.elearning.web.controller;

import com.elearning.entity.User;
import com.elearning.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {

    @Mock
    UserService userService;

    MockMvc mockMvc;

    UserController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        controller = new UserController(userService);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllUsers() throws Exception {
        User user = User.builder().user_id(1l).username("testuser").reg_date(LocalDateTime.now()).build();
        User user0 = User.builder().user_id(2l).username("usertest").reg_date(LocalDateTime.now()).build();

        List<User> users = Arrays.asList(user, user0);

        Mockito.when(userService.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/api/v1/users"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username", Matchers.is("testuser")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].reg_date").exists());
    }

    @Test
    void getUserById() throws Exception {
        User user = User.builder().user_id(1l).username("testuser").reg_date(LocalDateTime.now()).build();

        Long searchedId = 1l;

        Mockito.when(userService.getUserByid(searchedId)).thenReturn(Optional.ofNullable(user));

        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username", Matchers.is("testuser")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reg_date").exists());
    }

    @Test
    void saveUser() throws Exception {
        User user = User.builder().user_id(1l).username("testuser").build();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        Mockito.when(userService.saveUser(user)).thenReturn(user);


        mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$").hasJsonPath())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username", Matchers.is("testuser")));
    }

    @Test
    void updateUser() throws Exception {
        User user = User.builder().user_id(1l).username("testuser").build();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        Mockito.when(userService.updateUser(user)).thenReturn(user);


        mockMvc.perform(put("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").hasJsonPath())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username", Matchers.is("testuser")));
    }

    @Test
    void deleteUser() throws Exception {
        Long searchedId = 1l;

        Mockito.when(userService.deleteUser(searchedId)).thenReturn(true);

        mockMvc.perform(delete( "/api/v1/users/{id}", searchedId))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isBoolean());
    }
}