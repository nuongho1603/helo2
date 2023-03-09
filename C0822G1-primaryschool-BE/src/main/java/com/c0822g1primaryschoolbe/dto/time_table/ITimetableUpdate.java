package com.c0822g1primaryschoolbe.dto.time_table;

public class ITimetableUpdate {
    private Long timetableId;

    private Long subjectId;


    public ITimetableUpdate() {
    }

    public Long getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(Long timetableId) {
        this.timetableId = timetableId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}
