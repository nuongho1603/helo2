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
public class StudentRestController_getInfoStudent {
    @Autowired
    private MockMvc mockMvc;

    /**
     * this function check get id is Empty.
     *
     * @author NuongHT
     * @Time 15:00 28/2/2023
     */
    @Test
    public void getInfoStudent_id_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/info/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function check get id blank
     *
     * @author NuongHT
     * @Time 15:00 28/2/2023
     */
    @Test
    public void getInfoStudent_id_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/info/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function check get id not exist
     *
     * @author NuongHT
     * @Time 15:00 28/2/2023
     */
    @Test
    public void getInfoStudent_id_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/info/{id}", "100"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * this function check get id successful
     *
     * @author NuongHT
     * @Time 15:00 28/2/2023
     */
    @Test
    public void getInfoStudent_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/info/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(jsonPath("studentId").value(1),
                        jsonPath("dateOfBirth").value("11/12/2004"),
                        jsonPath("address").value("QN"),
                        jsonPath("gender").value("false"),
                        jsonPath("fatherJob").value("Bác sĩ "),
                        jsonPath("motherJob").value("Diễn viên"),
                        jsonPath("fatherName").value("Trần Thái Tổ"),
                        jsonPath("phoneNumberFather").value("0362023458"),
                        jsonPath("phoneNumberMother").value("0945399867"),
                        jsonPath("img").value("https://wallpapercave.com/wp/wp6561789.jpg"),
                            jsonPath("religion").value("Không có")

                );
    }
}
