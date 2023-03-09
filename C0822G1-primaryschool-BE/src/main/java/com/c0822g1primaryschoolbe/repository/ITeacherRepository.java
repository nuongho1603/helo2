package com.c0822g1primaryschoolbe.repository;

import com.c0822g1primaryschoolbe.dto.ITeacherDto;
import com.c0822g1primaryschoolbe.dto.teacher.TeacherDtoToSearch;
import com.c0822g1primaryschoolbe.dto.teacher.ITeacherDtoTuan;
import com.c0822g1primaryschoolbe.dto.teacher.ITeacherInfo;
import com.c0822g1primaryschoolbe.dto.teacher.TeacherViewDto;
import com.c0822g1primaryschoolbe.entity.teacher.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ITeacherRepository extends JpaRepository<Teacher, Long> {

    /**
     * Created by: MinhCDK
     * Date created: 28/02/2023
     * Function: editInfoTeacher
     */

    @Modifying
    @Query(value = "update teacher set email = :email, phone_number = :phoneNumber, address = :address where teacher_id= :teacherId", nativeQuery = true)
    void editInfoTeacher(@Param("email") String email,
                         @Param("phoneNumber") String phoneNumber,
                         @Param("address") String address,
                         @Param("teacherId") Long teacherId);

        /**
         * Create by TuanNDN
         *
         * @param teacherId
         * @return
         */
        @Query(value = "SELECT * from teacher where teacher_id = :teacherId and flag_delete = false",
                nativeQuery = true)
        Optional<Teacher> findByIdTeacher(@Param("teacherId") Long teacherId);

        /**
         * Create by TuanNDN
         *
         * @return
         */
        @Query(value = "SELECT teacher.teacher_id as teacherId, teacher.teacher_name as teacherName FROM `teacher`", nativeQuery = true)
        List<ITeacherDtoTuan> showListTeacher();

        /**
         * Create by : TrungNQ
         * Date create: 27/02/2023
         *
         * @param year Description: take teacher info by id year
         **/
        @Query(value = "select t.teacher_id as id,t.teacher_name as name,t.id_card as idCard from teacher t where t.teacher_id not in (select t.teacher_id from teacher t join clazz c on t.teacher_id=c.teacher_id where c.year=:year);", nativeQuery = true)
        List<ITeacherInfo> getListNameTeacher(@Param("year") int year);


        /**
         * Create by:TrungNQ
         * Date create:27/2/2023
         * Funciton: get teacher name by Param
         */
        @Query(value = "select t.teacher_id as id,t.teacher_name as name,t.id_card as idCard from teacher t where (t.teacher_id not in (select t.teacher_id from teacher t join clazz c on t.teacher_id=c.teacher_id where c.year=:year) and t.id_card=:idCard)", nativeQuery = true)
        ITeacherInfo getNameTeacher(@Param("idCard") String idCard, @Param("year") int year);


        /**
         * Create by : VanNTC
         * Date create: 27/02/2023
         * Description: take teacher by id Account
         *
         * @param accountId *return Teacher
         **/
        @Query(value = "select teacher.teacher_id as teacherId from teacher\n" +
                "where teacher.account_id=:accountId", nativeQuery = true, countQuery = "select teacher.teacher_id as teacherId from teacher\n" +
                "where teacher.account_id=:accountId")
        TeacherViewDto findIdTeacher(@Param("accountId") Long accountId);

        /**
         * Created by: MinhCDK
         * Date created: 03/03/2023
         * Function: findByTeacherDto
         */

        @Query(value = "select teacher_id as teacherId, teacher_name as teacherName, date_of_birth as dateOfBirth, gender as gender, d.degree_name as degreeName, teacher_type as teacherType, id_card as idCard, email as email, phone_number as phoneNumber, address as address from teacher join degree d on d.degree_id = teacher.degree_id where teacher_id =:teacherId", nativeQuery = true)
        com.c0822g1primaryschoolbe.dto.teacher.ITeacherDto findByTeacherDto(@Param("teacherId") Long teacherId);

        @Query(value = "select teacher.* from teacher where teacher.teacher_name like %:name% and teacher.teacher_status = :status order by teacher.teacher_name asc ", nativeQuery = true)
        Page<Teacher> findByName(@Param("name") String name,
                                 @Param("status") Boolean status,
                                 Pageable pageable);

        /**
         * create by :VinhLD
         * date create 27/02/2023
         * funtion : search teacher by name and status
         *
         * @param "name"
         * @return
         */
        @Query(value = " select `teacher`.teacher_id as idTeacher , `teacher`.teacher_name as nameTeacher, `teacher`.date_of_birth as dateOfBirthTeacher,`teacher`.email as emailTeacher, `teacher`.id_card as idCardTeacher from `teacher` where `teacher`.teacher_name like %:#{#teacherDtoToSearch.nameTeacher}% " +
                " and `teacher`.teacher_status = :#{#teacherDtoToSearch.teachStatus} order by `teacher`.teacher_name asc", nativeQuery = true)
        Page<com.c0822g1primaryschoolbe.dto.ITeacherDto> searchTeacher(@Param("teacherDtoToSearch") TeacherDtoToSearch teacherDtoToSearch, Pageable pageable);

    }
