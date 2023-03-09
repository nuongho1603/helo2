package com.c0822g1primaryschoolbe.dto.teacher;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class TeacherDto {
    private Long teacherId;
    @NotBlank(message = "Email không được để trống")
    @Pattern(message = "Email không đúng định dạng", regexp = "[\\w]+[@][\\w]+.[\\w]+")
    private String email;
    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(message = "Số điện thoại không đúng định dạng", regexp = "^(((\\\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})$")
    private String phoneNumber;
    @NotBlank(message = "Địa chỉ nhà không được để trống")
    private String address;

    public TeacherDto(Long teacherId, String email, String phoneNumber, String address) {
        this.teacherId = teacherId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
