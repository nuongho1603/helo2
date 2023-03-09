package com.c0822g1primaryschoolbe.dto.student;

public class StudentDtoToSearch {
    private String nameStudent;
    private Boolean studyStatus;

    public StudentDtoToSearch() {
    }

    public StudentDtoToSearch(String nameStudent, Boolean studyStatus) {
        this.nameStudent = nameStudent;
        this.studyStatus = studyStatus;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Boolean getStudyStatus() {
        return studyStatus;
    }

    public void setStudyStatus(Boolean studyStatus) {
        this.studyStatus = studyStatus;
    }
}
