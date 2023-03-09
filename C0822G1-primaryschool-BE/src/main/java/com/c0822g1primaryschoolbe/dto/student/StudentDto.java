package com.c0822g1primaryschoolbe.dto.student;

import com.c0822g1primaryschoolbe.dto.clazz.ClazzDto;
import com.c0822g1primaryschoolbe.entity.clazz.Clazz;
import com.c0822g1primaryschoolbe.entity.student.PointManagement;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StudentDto  {
    private Long studentId;
    @NotBlank(message = "Không được để trống!")
    private String img;
    @NotBlank(message = "Không được để trống!")
    private String studentName;
    @NotBlank(message = "Không được để trống!")
    private String dateOfBirth;
    private boolean gender;
    @NotBlank(message = "Không được để trống!")
    private String fatherName;
    @NotBlank(message = "Không được để trống!")
    private String phoneNumberFather;
    @NotBlank(message = "Không được để trống!")
    private String fatherJob;
    @NotBlank(message = "Không được để trống!")
    private String motherName;
    @NotBlank(message = "Không được để trống!")
    private String phoneNumberMother;
    @NotBlank(message = "Không được để trống!")
    private String motherJob;
    @NotBlank(message = "Không được để trống!")
    private String religion;
    @NotBlank(message = "Không được để trống!")
    private String address;
    private boolean studentStatus;
    private boolean flagDelete;
    private ClazzDto clazzDto;

    public StudentDto() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getPhoneNumberFather() {
        return phoneNumberFather;
    }

    public void setPhoneNumberFather(String phoneNumberFather) {
        this.phoneNumberFather = phoneNumberFather;
    }

    public String getFatherJob() {
        return fatherJob;
    }

    public void setFatherJob(String fatherJob) {
        this.fatherJob = fatherJob;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getPhoneNumberMother() {
        return phoneNumberMother;
    }

    public void setPhoneNumberMother(String phoneNumberMother) {
        this.phoneNumberMother = phoneNumberMother;
    }

    public String getMotherJob() {
        return motherJob;
    }

    public void setMotherJob(String motherJob) {
        this.motherJob = motherJob;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public ClazzDto getClazzDto() {
        return clazzDto;
    }

    public void setClazzDto(ClazzDto clazzDto) {
        this.clazzDto = clazzDto;
    }
}
