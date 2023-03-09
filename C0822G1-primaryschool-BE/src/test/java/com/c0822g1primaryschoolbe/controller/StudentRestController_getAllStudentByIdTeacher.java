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
public class StudentRestController_getAllStudentByIdTeacher {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllStudentByIdTeacher_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/student/list-student?null&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAllStudentByIdTeacher_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/student/list-student?&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAllStudentByIdTeacher_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/student/list-student?10&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void getAllStudentByIdTeacher_11() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/student/list-student/1?page=0"))
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].studentName").value("Nguyễn Chí Hiếu"))
                .andExpect(jsonPath("content[0].gender").value(false))
                .andExpect(jsonPath("content[0].dateOfBirth").value("2011-12-14"))
                .andExpect(jsonPath("content[0].studentId").value("2"))
                .andExpect(status().is2xxSuccessful());
    }
}

