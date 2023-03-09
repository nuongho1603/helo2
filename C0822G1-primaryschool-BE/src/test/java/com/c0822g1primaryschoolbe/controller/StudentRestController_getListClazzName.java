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
public class StudentRestController_getListClazzName {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListClazzName_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListClazzName_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student?year=2023&name=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].name").value("1A"))
                .andExpect(jsonPath("$[0].id").value("2"));

    }

}
