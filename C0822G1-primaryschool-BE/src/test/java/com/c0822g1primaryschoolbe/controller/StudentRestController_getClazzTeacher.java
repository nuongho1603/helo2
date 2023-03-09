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
public class StudentRestController_getClazzTeacher {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getClazzTeacher_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student/clazz"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getClazzTeacher_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student/clazz/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getClazzTeacher_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student/clazz?year=2000"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getClazzTeacher_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/student/clazz?year=2023&clazzId=2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("name").value("1A"))
                .andExpect(jsonPath("id").value(2))
                .andExpect(jsonPath("schoolYear").value("2023-2028"))
                .andExpect(jsonPath("teacherId").value(7))
                .andExpect(jsonPath("teacherName").value("Nông Văn Thanh"));

    }

}

