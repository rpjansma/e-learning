package com.elearning.web.controller;

import com.elearning.entity.User;
import com.elearning.service.integration.UserServiceApiOpenFeign;
import com.elearning.service.integration.UserServiceApiRestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ExternalUserControllerTest {

    @Mock
    UserServiceApiRestTemplate userServiceApiRestTemplate;

    @Mock
    UserServiceApiOpenFeign userServiceApiOpenFeign;

    MockMvc mockMvc;

    ExternalUserController controller;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        controller = new ExternalUserController(userServiceApiOpenFeign, userServiceApiRestTemplate);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getExternalUserById() throws Exception {
        User user = User.builder().user_id(1l).username("testuser").reg_date(LocalDateTime.now()).build();

        Long searchedId = 1l;

        Mockito.when(userServiceApiOpenFeign.getExternalUserById(searchedId)).thenReturn(user);

        mockMvc.perform(get("/api/v1/feign/users/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username", Matchers.is("testuser")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reg_date").exists());
    }

    @Test
    void getExternalUsersWithFeign() throws Exception {

        User user = User.builder().user_id(1l).username("testuser").reg_date(LocalDateTime.now()).build();
        User user0 = User.builder().user_id(2l).username("usertest").reg_date(LocalDateTime.now()).build();

        List<User> users = Arrays.asList(user, user0);

        Mockito.when(userServiceApiOpenFeign.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/api/v1/feign/users"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username", Matchers.is("testuser")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].reg_date").exists());
    }

    @Test
    void saveUserWithFeign() throws Exception {
        User user = User.builder().user_id(1l).username("testuser").build();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        Mockito.when(userServiceApiOpenFeign.createNewUser(user)).thenReturn((List<User>) user);


        mockMvc.perform(post("/api/v1/feign/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$").hasJsonPath())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username", Matchers.is("testuser")));
    }

    @Test
    void getExternalUsersWithRest() throws Exception {
        User user = User.builder().user_id(1l).username("testuser").reg_date(LocalDateTime.now()).build();
        User user0 = User.builder().user_id(2l).username("usertest").reg_date(LocalDateTime.now()).build();

        List<User> users = Arrays.asList(user, user0);

        Mockito.when(userServiceApiOpenFeign.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/api/v1/rest/users"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username", Matchers.is("testuser")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].reg_date").exists());
    }

    @Test
    void getUserByIdWithRest() throws Exception {
        User user = User.builder().user_id(1l).username("testuser").reg_date(LocalDateTime.now()).build();

        Long searchedId = 1l;

        Mockito.when(userServiceApiRestTemplate.getUserById(searchedId)).thenReturn(user);

        mockMvc.perform(get("/api/v1/rest/users/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username", Matchers.is("testuser")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reg_date").exists());
    }

    @Test
    void saveUserWithRest() throws Exception {
        User user = User.builder().user_id(1l).username("testuser").build();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        Mockito.when(userServiceApiRestTemplate.createNewUser(user)).thenReturn(ResponseEntity.of(Optional.ofNullable(user)));


        mockMvc.perform(post("/api/v1/rest/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$").hasJsonPath());
    }
}