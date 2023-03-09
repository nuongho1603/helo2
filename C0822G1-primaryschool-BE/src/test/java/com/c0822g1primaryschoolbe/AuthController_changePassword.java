package com.c0822g1primaryschoolbe;

import com.c0822g1primaryschoolbe.dto.request.ChangePasswordDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthController_changePassword {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this function check new pass null
     *
     * @author NuongHT
     * @Time 15:00 28/2/2023
     */
    @Test
    public void updatePassword_newPass_19() throws Exception {

        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setNewPass("null");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api-auth/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function check new pass blank
     *
     * @author NuongHT
     * @Time 15:00 28/2/2023
     */
    @Test
    public void updatePassword_newPass_20() throws Exception {

        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setNewPass(" ");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api-auth/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function check new pass use format vaidation (uppercase, lowercase, numbers or special characters);
     *
     * @author NuongHT
     * @Time 15:00 28/2/2023
     */
    @Test
    public void updatePassword_newPass_21() throws Exception {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setAccountId(1L);
        changePasswordDto.setNewPass("nguyenhann");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api-auth/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function check new pass format validator (minlength = 9)
     *
     * @author NuongHT
     * @Time 15:00 28/2/2023
     */
    @Test
    public void updatePassword_newPass_22() throws Exception {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setAccountId(1L);
        changePasswordDto.setNewPass("s");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api-auth/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function check new pass use maxlength (maxlength = 30)
     *
     * @author NuongHT
     * @Time 15:00 28/2/2023
     */

    @Test
    public void updatePassword_newPass_23() throws Exception {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setAccountId(1L);
        changePasswordDto.setNewPass("Njsssssssssggggggggggggggggggggggggggggggggggggggggggggggggggggggggssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api-auth/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function check new pass correct
     *
     * @author NuongHT
     * @Time 15:00 28/2/2023
     */

    @Test
    public void updatePassword_newPass_24() throws Exception {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setAccountId(1L);
        changePasswordDto.setNewPass("HelloC08!");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api-auth/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
