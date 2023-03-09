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
public class TimeTableRestController_showTimeTable {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void showTimeTable_teacherId_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/time-table/{teacherId}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void showTimeTable_teacherId_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/time-table/{teacherId}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void showTimeTable_teacherId_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/time-table/{teacherId}", "10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void showTimeTable_teacherId_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/time-table/{teacherId}","1"))
                .andDo(print())
                .andExpectAll(jsonPath("teacherId").value(1),
                        jsonPath("nameSubject").value("Toán"),
                        jsonPath("nameDay").value("Thứ 2"),
                        jsonPath("nameLesson").value("Tiết 1"))
                .andExpect(status().is2xxSuccessful());
    }
}
