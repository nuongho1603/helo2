package com.c0822g1primaryschoolbe.controller;

import com.c0822g1primaryschoolbe.dto.request.SignInForm;
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
public class SecurityController_login {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ObjectMapper objectMapper;

    /** create SyTV
     *  test method login
     *
     * @throws Exception
     */

    //username = null
    @Test
    public void login_username_13() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setPassword("456");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/sign-in").
                content(this.objectMapper.writeValueAsString(signInForm))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    //username = ""
    @Test
    public void login_username_14() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("");
        signInForm.setPassword("456");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/sign-in").
                content(this.objectMapper.writeValueAsString(signInForm))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    //username = ký tự đặc biệt
    @Test
    public void login_username_15() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("^^&%^&%&");
        signInForm.setPassword("456");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/sign-in").
                        content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    //username < minlength
    @Test
    public void login_username_16() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("qw");
        signInForm.setPassword("456");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/sign-in").
                        content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    //username > maxlength
    @Test
    public void login_username_17() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        signInForm.setPassword("456");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/sign-in").
                        content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    //password = null
    @Test
    public void login_password_13() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("sytv");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/sign-in").
                        content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    //password = ""
    @Test
    public void login_password_14() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("sytv");
        signInForm.setPassword("");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/sign-in").
                        content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    //password = ký tự đặc biệt
    @Test
    public void login_password_15() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("sytv");
        signInForm.setPassword("%^^$&$&^");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/sign-in").
                        content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    //password < minlength
    @Test
    public void login_password_16() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("sytv");
        signInForm.setPassword("as");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/sign-in").
                        content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    //password > maxlength
    @Test
    public void login_password_17() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("sytv");
        signInForm.setPassword("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/sign-in").
                        content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    //username = sytv
    //password = 456
    // matching
    @Test
    public void login_signInForm_18() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("sytv");
        signInForm.setPassword("456");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/sign-in").
                        content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
        ;
    }

    //logout xử lý trên fornt end nên không có phương thức
}
