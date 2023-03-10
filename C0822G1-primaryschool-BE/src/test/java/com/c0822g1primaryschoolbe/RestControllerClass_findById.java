package com.c0822g1primaryschoolbe;

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
public class RestControllerClass_findById {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getInfoStudent_id_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/{2}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/{1}", "3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
