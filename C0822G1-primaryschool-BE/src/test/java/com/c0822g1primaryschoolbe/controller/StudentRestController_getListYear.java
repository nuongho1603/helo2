package com.c0822g1primaryschoolbe.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestController_getListYear {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListYear_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void getListYear_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student/year"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].year").value(2023));

    }

}
