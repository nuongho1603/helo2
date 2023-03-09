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
public class TeacherRestController_seacrhTeacher {
    @Autowired
    private MockMvc mockMvc;



    /**
     * This function use to test list teacher of all field search is null
     *
     * @author VinhLD
     * @Date 28/02/2023
     */

    @Test
    public void getAllTeacher_7() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/teachers?name=null&status=null&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test list teacher of all field search is "", page =0
     *
     *
     * @author VinhLD
     * @Date 28/02/2023
     */

    @Test
    public void  getAllTeacher_8() throws Exception{

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/teachers?name=&status=&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))


                .andExpect(jsonPath("content[0].idTeacher").value(1))
                .andExpect(jsonPath("content[0].nameTeacher").value("le duc vinh"))
                .andExpect(jsonPath("content[0].dateOfBirth").value("121221"))
                .andExpect(jsonPath("content[1].idStudent").value(2))
                .andExpect(jsonPath("content[1].nameStudent").value("Pham thi vi"))

                .andExpect(jsonPath("content[1].dateOfBirth").value("1212221"))
        ;
    }

    /**
     * This function use to test list teacher of name search is abc
     *
     * @author VinhLD
     * @Date 28/02/2023
     */
    @Test
    public void getAllTeacher_nameSearch_9() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("teachers?name=abc&status=&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function use to test list teacher of name search is le duc vinh but flag_deleted = true
     *
     * @author VinhLD
     * @Date 28/02/2023
     */

    @Test
    public void getAllTeacher_nameTeacher_10() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("teachers?name=le duc vinh&status=&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test list teacher of name search is le duc vinh, page = 0
     *
     * @author VinhLD
     * @Date  28/02/2023
     */


    @Test
    public void getAllTeacher_nameTeacher_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("teachers?name=le duc vinh&status=&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].idTeacher").value(1))
                .andExpect(jsonPath("content[0].nameTeacher").value("le duc vinh"))
                .andExpect(jsonPath("content[0].dateOfBirth").value("121221"));

    }



    /**
     * This function use to test list teacher of name search is  v, page = 0
     *
     * @author VinhLD
     * @Date  28/02/2023
     */


    @Test
    public void getAllTeacher_name_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("teachers?name=v&status=&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].idTeacher").value(1))
                .andExpect(jsonPath("content[0].nameTeacher").value("le duc vinh"))
                .andExpect(jsonPath("content[0].dateOfBirth").value("121221"))
                .andExpect(jsonPath("content[1].idTeacher").value(2))
                .andExpect(jsonPath("content[1].nameTeacher").value("Pham thi vi"))
                .andExpect(jsonPath("content[1].dateOfBirth").value("1212221"));
    }


    /**
     * This function use to test list teacher of name search is  v and stutus =false , page = 0
     *
     * @author VinhLD
     * @Date  28/02/2023
     */


    @Test
    public void getAllTeacher_name_and_status_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("teachers?name=v&status=false&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].idTeacher").value(1))
                .andExpect(jsonPath("content[0].nameTeacher").value("le duc vinh"))
                .andExpect(jsonPath("content[0].dateOfBirth").value("121221"));


    }

    /**
     * This function use to test list teacher of name search is  v and stutus =true , page = 0
     *
     * @author VinhLD
     * @Date  28/02/2023
     */

    @Test
    public void getAllStudent_nameStudent_and_status_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("students?name=v&status=true&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].idStudent").value(2))
                .andExpect(jsonPath("content[0].nameStudent").value("Pham thi vi"))
                .andExpect(jsonPath("content[0].dateOfBirth").value("1212221"));


    }

}
