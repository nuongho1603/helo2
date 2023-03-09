package com.c0822g1primaryschoolbe.dto.teacher;

public class TeacherDtoToSearch {
        private String nameTeacher;
    private Boolean teachStatus;

    public TeacherDtoToSearch() {
    }

    public TeacherDtoToSearch(String nameTeacher, Boolean teachStatus) {
        this.nameTeacher = nameTeacher;
        this.teachStatus = teachStatus;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public Boolean getTeachStatus() {
        return teachStatus;
    }

    public void setTeachStatus(Boolean teachStatus) {
        this.teachStatus = teachStatus;
    }
}
