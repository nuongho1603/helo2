package com.c0822g1primaryschoolbe.entity.time_table_subject;

import com.c0822g1primaryschoolbe.entity.clazz.Clazz;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_table_id")
    private Long timeTableId;
    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clazz_id")
    private Clazz clazz;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "subject_id",nullable = false,referencedColumnName = "subject_id")
    private Subject subject;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false,referencedColumnName = "lesson_id")
    private Lesson lesson;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "day_id", nullable = false,referencedColumnName = "day_id")
    private Day day;

    public Long getTimeTableId() {
        return timeTableId;
    }

    public void setTimeTableId(Long timeTableId) {
        this.timeTableId = timeTableId;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

}