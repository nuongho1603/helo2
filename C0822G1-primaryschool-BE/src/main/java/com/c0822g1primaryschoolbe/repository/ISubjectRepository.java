package com.c0822g1primaryschoolbe.repository;

import com.c0822g1primaryschoolbe.entity.time_table_subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long> {
    /**
     * Create by : NamHH
     * Date created: 28/02/2023
     * Function: get all subject
     **/
    @Query(value = "select* from subject", countQuery = "select* from subject", nativeQuery = true)
    List<Subject> findAllSubject();
}
