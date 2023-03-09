package com.c0822g1primaryschoolbe.dto.clazz;

public class ClazzTeacherDto {
    private Long clazzId;
    private Long teacherId;

    public ClazzTeacherDto() {
    }

    public ClazzTeacherDto(Long clazzId, Long teacherId) {
        this.clazzId = clazzId;
        this.teacherId = teacherId;
    }

    public Long getClazzId() {
        return clazzId;
    }

    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
