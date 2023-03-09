package com.c0822g1primaryschoolbe.entity.teacher;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonBackReference
    @Column(name = "degree_id")
    private Long degreeId;

    @JsonBackReference
    @Column(columnDefinition = "varchar(45)")
    private String degreeName;

    public Degree(Long degreeId) {
        this.degreeId = degreeId;
    }

    public Degree() {

    }

    public Long getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Long degreeId) {
        this.degreeId = degreeId;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
}
