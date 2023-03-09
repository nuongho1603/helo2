package com.c0822g1primaryschoolbe.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestController_deleteStudent {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void deleteStudent_25() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void deleteStudent_26() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteStudent_27() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student/{id}",100))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteStudent_28() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student/{id}",2))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
