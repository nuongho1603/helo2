package com.c0822g1primaryschoolbe.service.subject;

import com.c0822g1primaryschoolbe.entity.time_table_subject.Subject;

import java.util.List;

public interface ISubjectService {
    /**
     * Create by : NamHH
     * Date created: 28/02/2023
     * Function: get all subject
     **/
    List<Subject> findAllSubject();
}
