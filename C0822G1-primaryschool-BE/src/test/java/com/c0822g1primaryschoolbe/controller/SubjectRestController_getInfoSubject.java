package com.c0822g1primaryschoolbe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class SubjectRestController_getInfoSubject {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void getInfoSubject_id_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/listSubject/3"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoSubject_id_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/listSubject"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(jsonPath("$[0].subjectId").value(1),
                        jsonPath("$[0].subjectName").value("Văn"))
                .andExpect(status().is2xxSuccessful());
    }


}
