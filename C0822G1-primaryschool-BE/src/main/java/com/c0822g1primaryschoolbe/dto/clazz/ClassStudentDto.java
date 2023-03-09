package com.c0822g1primaryschoolbe.dto.clazz;

import com.c0822g1primaryschoolbe.dto.BlockDto;
import com.c0822g1primaryschoolbe.dto.TeacherDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ClassStudentDto implements Validator {
    /**
     * Create by TuanNDN
     */
    private Long clazzId;
    private String clazzName;
    private Boolean flagDelete;
    private Integer year;
    private String schoolYear;
    private BlockDto block;
    private TeacherDto teacher;

    public ClassStudentDto() {
    }

    public Long getClazzId() {
        return clazzId;
    }

    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public Boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

//    public TimeTable getTimeTable() {
//        return timeTable;
//    }
//
//    public void setTimeTable(TimeTable timeTable) {
//        this.timeTable = timeTable;
//    }

    public BlockDto getBlock() {
        return block;
    }

    public void setBlock(BlockDto block) {
        this.block = block;
    }

    public TeacherDto getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDto teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
