package com.c0822g1primaryschoolbe.dto.clazz;

import com.c0822g1primaryschoolbe.dto.TeacherDto;
import com.sun.istack.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ClazzDto implements Validator {
    private Long clazzId;
    @NotBlank
    @NotNull
    @Pattern(regexp = "^[1-5][A-Z]{1,4}$", message = "Tên lớp học chưa đúng định dạng")
    @Size(min = 1)
    @Size(max = 15)
    private String clazzName;
    @NotBlank
    @NotNull
    private String schoolYear;
    private TeacherDto teacherDto;
    private Integer year;

    public Long getClazzId() {
        return clazzId;
    }

    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public TeacherDto getTeacherDto() {
        return teacherDto;
    }

    public void setTeacherDto(TeacherDto teacherDto) {
        this.teacherDto = teacherDto;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}