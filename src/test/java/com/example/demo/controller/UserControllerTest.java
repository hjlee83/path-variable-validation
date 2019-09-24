package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void path_variable_number() throws Exception {
        mockMvc.perform(get("/users/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void path_variable_not_number() throws Exception {
        mockMvc.perform(get("/users/{id}", "a"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("getUser.userValid.id: 숫자만 가능합니다."));
    }
}