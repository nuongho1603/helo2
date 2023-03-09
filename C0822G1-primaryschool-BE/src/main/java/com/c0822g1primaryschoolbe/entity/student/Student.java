package com.c0822g1primaryschoolbe.entity.student;

import com.c0822g1primaryschoolbe.entity.clazz.Clazz;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnore;



import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;
    private String img;
    @Column(columnDefinition = "varchar(45)")
    private String studentName;
    private String dateOfBirth;
    private Boolean gender;
    @Column(columnDefinition = "varchar(45)")
    private String fatherName;
    @Column(columnDefinition = "varchar(45)")
    private String phoneNumberFather;
    @Column(columnDefinition = "varchar(45)")
    private String fatherJob;
    @Column(columnDefinition = "varchar(45)")
    private String motherName;
    @Column(columnDefinition = "varchar(45)")
    private String phoneNumberMother;
    @Column(columnDefinition = "varchar(45)")
    private String motherJob;
    @Column(columnDefinition = "varchar(45)")
    private String religion;
    private String address;
    private Boolean studentStatus;
    private Boolean flagDelete;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "clazz_id", nullable = false, referencedColumnName = "clazz_id")
    private Clazz clazz;

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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
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

    public Boolean getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(Boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    public Boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

}