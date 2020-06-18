package com.example.tdddemo.controller;

import com.example.tdddemo.BaseTest;
import com.example.tdddemo.entities.User;
import com.example.tdddemo.services.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UsuarioController.class)
@ExtendWith(SpringExtension.class)
public class UserControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    void getJsonContentOnGetAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/all").contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").exists()).andDo(print());
    }

    @Test
    void getResponseCode200OnGetAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/all").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getResponseCode200OnRegisterUser() throws Exception {
        User user = new User();
        mockMvc.perform(
            post("/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user))
        ).andExpect(status().isOk());
    }

    @Test
    void getEntitySavedOnRegisterUser() throws Exception {
        User userRegistrado = new User();
        userRegistrado.setId(Long.parseLong("1"));

        when(usuarioService.registerUser(any())).thenReturn(userRegistrado);

        mockMvc.perform(
            post("/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(new User()))
        ).andExpect(jsonPath("$.id").isNumber()).andDo(print());
    }
}
