package com.c0822g1primaryschoolbe;


import com.c0822g1primaryschoolbe.dto.clazz.ClassStudentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RestControllerClazz_updateClazz {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateClazz_clazzName_19() throws Exception {

        ClassStudentDto classStudentDto = new ClassStudentDto();
        classStudentDto.setClazzName("1D");
        classStudentDto.getTeacher().setTeacherId(3L);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/update/{1}")
                        .content(this.objectMapper.writeValueAsString(classStudentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateClazz_clazzName_24() throws Exception {

        ClassStudentDto classStudentDto = new ClassStudentDto();
        classStudentDto.setClazzName("1D");
        classStudentDto.getTeacher().setTeacherId(7L);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/update/{1}")
                        .content(this.objectMapper.writeValueAsString(classStudentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }





}
