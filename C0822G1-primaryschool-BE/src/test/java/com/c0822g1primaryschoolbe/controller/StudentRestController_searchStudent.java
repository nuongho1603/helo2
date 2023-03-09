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
public class StudentRestController_searchStudent {


@Autowired
private MockMvc mockMvc;


/**
 * This function use to test list student of all field search is null
 *
 * @author VinhLD
 * @Date 28/02/2023
 */

@Test
public void getAllStudent_7() throws Exception {

    this.mockMvc.perform(
                    MockMvcRequestBuilders
                            .get("/students?name=null&status=null&page=0"))
            .andDo(print())
            .andExpect(status().is4xxClientError());
}

/**
 * This function use to test list student of all field search is "", page =0
 *
 *
 * @author VinhLD
 * @Date 28/02/2023
 */

@Test
    public void  getAllStudent_8() throws Exception{

    this.mockMvc.perform(
                    MockMvcRequestBuilders
                            .get("/students?name=&status=&page=0"))
            .andDo(print())
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("totalPages").value(1))
            .andExpect(jsonPath("totalElements").value(1))


            .andExpect(jsonPath("content[0].studentId").value(1))
            .andExpect(jsonPath("content[0].studentName").value("le duc vinh"))
            .andExpect(jsonPath("content[0].address").value("viet nam"))
            .andExpect(jsonPath("content[0].dateOfBirth").value("111111"))
//            .andExpect(jsonPath("content[1].idStudent").value(2))
//            .andExpect(jsonPath("content[1].nameStudent").value("Pham thi vi"))
//            .andExpect(jsonPath("content[1].address").value("viet nam"))
//            .andExpect(jsonPath("content[1].dateOfBirth").value("sjudjdh"))
    ;
}

    /**
     * This function use to test list student of name search is abc
     *
     * @author VinhLD
     * @Date 28/02/2023
     */
    @Test
    public void getAllStudent_nameSearch_9() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/students?name=abc&status=&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function use to test list student of name search is le duc vinh but flag_deleted = true
     *
     * @author VinhLD
     * @Date 28/02/2023
     */

    @Test
    public void getAlStudent_nameStudent_10() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/students?name=le duc vinh&status=&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test list student of name search is le duc vinh, page = 0
     *
     * @author VinhLD
     * @Date  28/02/2023
     */


    @Test
    public void getAllStudent_nameStudent_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/students?name=le duc vinh&status=&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].studentId").value(1))
                .andExpect(jsonPath("content[0].studentName").value("le duc vinh"))
                .andExpect(jsonPath("content[0].dateOfBirth").value("111111"));



    }



    /**
     * This function use to test list student of name search is  v, page = 0
     *
     * @author VinhLD
     * @Date  28/02/2023
     */


    @Test
    public void getAllStudent_name_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/students?name=v&status=&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].studentId").value(1))
                .andExpect(jsonPath("content[0].studentName").value("le duc vinh"))
                .andExpect(jsonPath("content[0].dateOfBirth").value("111111"));

    }


    /**
     * This function use to test list student of name search is  v and stutus =false , page = 0
     *
     * @author VinhLD
     * @Date  28/02/2023
     */


    @Test
    public void getAllStudent_name_and_status_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/students?name=v&status=false&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].studentId").value(1))
                .andExpect(jsonPath("content[0].studentName").value("le duc vinh"))
                .andExpect(jsonPath("content[0].dateOfBirth").value("111111"));


    }

    /**
     * This function use to test list student of name search is  v and stutus =true , page = 0
     *
     * @author VinhLD
     * @Date  28/02/2023
     */

    @Test
    public void getAllStudent_nameStudent_and_status_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/students?name=v&status=true&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].studentId").value(2))
                .andExpect(jsonPath("content[0].studentName").value("Pham thi vi"))
                .andExpect(jsonPath("content[0].dateOfBirth").value("sjudjdh"));

    }



}
