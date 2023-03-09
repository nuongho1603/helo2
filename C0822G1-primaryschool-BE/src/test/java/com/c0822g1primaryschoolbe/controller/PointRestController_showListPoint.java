package com.c0822g1primaryschoolbe.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by: MinhCDK
 * Date created: 28/02/2023
 * JUNIT5: showListPoint
 * @Param: teacherID
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PointRestController_showListPoint {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void showListPoint_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/pointManagement/")).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void showListPoint_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/pointManagement/" + "")).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void showListPoint_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/pointManagement/99")).andDo(print()).andExpect(status().isNoContent());
    }

    @Test
    public void showListPoint_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/pointManagement/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].conditionCheck").value(true))
                .andExpect(jsonPath("$[0].studentName").value("Minh 1"))
                .andExpect(jsonPath("$[0].dateOfBirth").value("3"))
                .andExpect(jsonPath("$[0].semesterOne").value(10))
                .andExpect(jsonPath("$[0].semesterTwo").value(10))
                .andExpect(jsonPath("$[0].avgPoint").value(10));

    }
}
