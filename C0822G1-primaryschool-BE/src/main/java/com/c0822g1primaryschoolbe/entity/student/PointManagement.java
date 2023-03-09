package com.c0822g1primaryschoolbe.entity.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
@Entity
public class PointManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double semesterOne;
    private Double semesterTwo;
    private Boolean conditionCheck;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSemesterOne() {
        return semesterOne;
    }

    public void setSemesterOne(Double semesterOne) {
        this.semesterOne = semesterOne;
    }

    public Double getSemesterTwo() {
        return semesterTwo;
    }

    public void setSemesterTwo(Double semesterTwo) {
        this.semesterTwo = semesterTwo;
    }

    public Boolean getConditionCheck() {
        return conditionCheck;
    }

    public void setConditionCheck(Boolean conditionCheck) {
        this.conditionCheck = conditionCheck;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
