package com.c0822g1primaryschoolbe.dto.point;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class EditPointDto {
    private Long id;
    @Min(value = 0, message = "Điểm học kỳ 1 không được nhỏ hơn 0")
    @Max(value = 10, message = "Điểm học kỳ 1 không được lớn hơn 10")
//    @Pattern(regexp = "\\d+", message = "Chỉ được phép nhập số")
    private Double semesterOne;
    @Min(value = 0, message = "Điểm học kỳ 2 không được nhỏ hơn 0")
    @Max(value = 10, message = "Điểm học kỳ 2 không được lớn hơn 10")
//    @Pattern( regexp = "\\d+",message = "Chỉ được phép nhập số")
    private Double semesterTwo;

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

    @Override
    public String toString() {
        return "EditPointDto{" +
                "id=" + id +
                ", semesterOne=" + semesterOne +
                ", semesterTwo=" + semesterTwo +
                '}';
    }
}
