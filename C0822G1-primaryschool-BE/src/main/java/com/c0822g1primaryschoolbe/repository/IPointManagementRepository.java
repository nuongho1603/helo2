package com.c0822g1primaryschoolbe.repository;

import com.c0822g1primaryschoolbe.dto.point.PointManagementDto;
import com.c0822g1primaryschoolbe.entity.student.PointManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public interface IPointManagementRepository extends JpaRepository<PointManagement, Long> {

    /**
     * Created by: MinhCDK
     * Date created: 28/02/2023
     * Function: showListPoint
     *
     * @Param: teacherID
     */

//    @Modifying
//    @Query(value = "select point_management.id as id, point_management.condition_check as conditionCheck , s.student_name as studentName, s.date_of_birth as dateOfBirth, point_management.semester_one as semesterOne, point_management.semester_two as semesterTwo, round(((point_management.semester_one + point_management.semester_two*2)/3),2) as avgPoint, c.clazz_name as clazzName from point_management  join student s on s.student_id = point_management.student_id join clazz c on c.clazz_id = s.clazz_id join teacher t on t.teacher_id = c.teacher_id where t.teacher_id = :teacherId", nativeQuery = true)
//    List<PointManagementDto> showListPoint(@Param("teacherId") Long teacherId);

    /**
     * Created by: MinhCDK
     * Date created: 22/03/2023
     * Function: editListPoint
     *
     * @Param: teacherID
     */

    @Modifying
    @Query(value = "update point_management set semester_one = :semesterOne, semester_two = :semesterTwo where id = :id", nativeQuery = true)
    void editPoint(@Param("semesterOne") Double semesterOne, @Param("semesterTwo") Double semesterTwo, @Param("id") Long id);

    /**
     * Created by: MinhCDK
     * Date created: 28/02/2023
     * Function: searchStudentName
     *
     * @Param: teacherID
     */

    @Modifying
    @Query(value = "select point_management.id as id, point_management.condition_check as conditionCheck , s.student_name as studentName, s.date_of_birth as dateOfBirth, point_management.semester_one as semesterOne, point_management.semester_two as semesterTwo, round(((point_management.semester_one + point_management.semester_two*2)/3),2) as avgPoint, c.clazz_name as clazzName from point_management  join student s on s.student_id = point_management.student_id join clazz c on c.clazz_id = s.clazz_id join teacher t on t.teacher_id = c.teacher_id where s.flag_delete = false and t.teacher_id = :teacherId and s.student_name like concat('%',:studentName,'%')", nativeQuery = true)
    List<PointManagementDto> findByStudentName(@Param("teacherId") Long teacherId, @Param("studentName") String studentName);

    @Modifying
    @Query(value = "update point_management set condition_check=false where id=:idPoint", nativeQuery = true)
    void checkBoxUpClazz(@Param("idPoint") Long idPoint);
}
