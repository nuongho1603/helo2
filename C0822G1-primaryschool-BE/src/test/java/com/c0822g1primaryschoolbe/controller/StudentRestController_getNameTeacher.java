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
public class StudentRestController_getNameTeacher {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getNameTeacher_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student/teacher-name"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getNameTeacher_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student/teacher-name?year=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getNameTeacher_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student/teacher-name?year=1999"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getNameTeacher_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student/teacher-name?idCard=123&year=2023"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("name").value("Nguyễn Văn Anh"))
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("idCard").value("123"));


    }

}
