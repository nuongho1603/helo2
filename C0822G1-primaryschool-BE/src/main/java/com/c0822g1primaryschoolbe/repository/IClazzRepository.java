package com.c0822g1primaryschoolbe.repository;

import com.c0822g1primaryschoolbe.dto.clazz.ClazzStudentDto;
import com.c0822g1primaryschoolbe.dto.clazz.IClazzName;
import com.c0822g1primaryschoolbe.dto.clazz.IClazzTeacher;
import com.c0822g1primaryschoolbe.dto.clazz.IClazzYear;
import com.c0822g1primaryschoolbe.entity.clazz.Block;
import com.c0822g1primaryschoolbe.entity.clazz.Clazz;
import com.c0822g1primaryschoolbe.entity.teacher.Teacher;
import com.c0822g1primaryschoolbe.dto.time_table.IClazz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface IClazzRepository extends JpaRepository<Clazz, Long> {
    /**
     * HoangNM
     * @param studentId
     * @return
     */
    @Query(value ="SELECT * from student join clazz on student.clazz_id = clazz.clazz_id where student_id = :studentId",

            countQuery = "SELECT * from student join clazz on student.clazz_id = clazz.clazz_id where student_id = :studentId",
            nativeQuery = true)
    Clazz findByIdClazzStudent(@Param("studentId") Long studentId);

    /**
     * Create by TuanNDN
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = "select * from clazz", countQuery = "select * from clazz", nativeQuery = true)
    List<Clazz> findAllClazz();

    /* Ngô Đình Nhật Tuấn*/
    @Query(value =
            " select c.*" +
                    " from `clazz` c " +
                    "join `teacher` t on t.teacher_id = c.teacher_id " +
                    "join `block` b on b.block_id = c.block_id " +
                    "where c.clazz_name like concat('%', :keySearch1 ,'%') " +
                    "and c.flag_delete=false " +
                    "order by c.clazz_name asc",
            countQuery =
                    " select c.*" +
                            " from `clazz` c " +
                            "join `teacher` t on t.teacher_id = c.teacher_id " +
                            "join `block` b on b.block_id = c.block_id " +
                            "where c.clazz_name like concat('%', :keySearch1 ,'%') " +
                            "and c.flag_delete=false " +
                            "order by c.clazz_name asc ",
            nativeQuery = true)
    Page<Clazz> findAllClazz(Pageable pageable, @Param("keySearch1") String keySearch1);

    /**
     * Create by TuanNDN
     * @param clazzId
     * @return
     */
    @Query(value ="SELECT * from clazz where clazz_id = :clazzId and flag_delete = false",
            countQuery = "SELECT * from clazz where clazz_id = :clazzId and flag_delete = false",
            nativeQuery = true)
    Clazz findByIdClazz(@Param("clazzId") Long clazzId);


    /**
     * Create by TuanNDN
     * @param clazzId
     * @param teacherId
     * @param clazzName
     * @param flagDelete
     * @param schoolYear
     * @param year
     * @param blockId
     */
    @Transactional
    @Modifying
    @Query(value =
            "UPDATE clazz c SET c.teacher_id = :teacherId, " +
                    "c.clazz_name = :clazzName, " +
                    "c.flag_delete = :flagDelete, " +
                    "c.school_year = :schoolYear, " +
                    "c.year = :year," +
                    "c.block_id =:blockId " +
                    "WHERE c.clazz_id = :clazzId",

            nativeQuery = true)
    void updateClazz(
            @Param("clazzId") Long clazzId,
            @Param("teacherId") Long teacherId,
            @Param("clazzName") String clazzName,
            @Param("flagDelete") Boolean flagDelete,
            @Param("schoolYear") String schoolYear,
            @Param("year") Integer year,
            @Param("blockId") Long blockId);


    /**
     * Create by TuanNDN
     */
    @Transactional
    @Modifying
    @Query(value =
            "update clazz" +
                    " set clazz.block_id = clazz.block_id + 1" +
                    " where clazz.block_id" +
                    " in (" +
                    " select p.student_id" +
                    " from block b" +
                    " join teacher t on t.teacher_id = clazz.teacher_id" +
                    " join student s on s.clazz_id = clazz.clazz_id" +
                    " join point_management p on s.student_id = p.student_id" +
                    " where p.condition_check = false)", nativeQuery = true)
    void upBlockNew();



    /** Method use: createChooseClass()
     * Created date: 27/02/2023
     * Function:createChooseClass
     * Parameter: contentClass
     * Author: DungND
     */
    @Transactional
    @Modifying
    @Query(value = "insert into `clazz` (clazz_name,school_year,block_id,teacher_id,flag_delete,year)VALUES(:clazzName,:schoolYear,:blockId,:teacherId,false,:year)"
            ,countQuery = "insert into `clazz` (clazz_name,school_year,block_id,teacher_id,flag_delete,year)VALUES(:clazzName,:schoolYear,:blockId,:teacherId,false,:year)"
            ,nativeQuery = true)
    void createChooseClass(@Param("clazzName") String clazzName,@Param("schoolYear") String schoolYear, @Param("blockId") Block blockId, @Param("teacherId") Teacher teacherId,@Param("year") Integer year);
    /**
     * create by : DungND
     * Data create: 27/02/2023
     * funcion: showListClassStudentById()
     *
     * @param 'id'
     */

    @Query(value = "SELECT `clazz`.clazz_id as clazzId,`clazz`.clazz_name as clazzName,`teacher`.teacher_id as teacherId,`teacher`.teacher_name as teacherName,`student`.student_id as studentId," +
            "`student`.student_name as studentName,`student`.date_of_birth as dateOfBirth,`student`.gender as gender,student.address as address FROM  `clazz` left join `student`  on `clazz`.clazz_id= `student`.clazz_id left join `teacher` on `clazz`.teacher_id = `teacher`.teacher_id  where `clazz`.clazz_id= :id"
            ,countQuery = "SELECT `clazz`.clazz_id as clazzId,`clazz`.clazz_name as clazzName,`teacher`.teacher_id as teacherId,`teacher`.teacher_name as teacherName,`student`.student_id as studentId," +
            "`student`.student_name as studentName,`student`.date_of_birth as dateOfBirth,`student`.gender as gender,`student`.address as address FROM  `clazz` left join `student`  on `clazz`.clazz_id= `student`.clazz_id left join `teacher` on `clazz`.teacher_id = `teacher`.teacher_id  where `clazz`.clazz_id= :id"
            ,nativeQuery = true)
    List<ClazzStudentDto> showListClassStudentById(@Param("id") long id);

    /**
     * create by : DungND
     * Data create: 27/02/2023
     * funcion: showListClass()
     */
    @Query(value = "SELECT clazz.clazz_id as clazzId,clazz.clazz_name as clazzName,teacher.teacher_id as teacherId,teacher.teacher_name as teacherName FROM `clazz` join teacher on clazz.teacher_id = teacher.teacher_id"
            ,nativeQuery = true)
    List<ClazzStudentDto> showListAll();


    /**
     * Create by NamHH
     * Date 01/03/2023
     * Function: showListClazz
     **/
    @Query(value = "select clazz_id as clazzId, clazz_name as clazzName from clazz where block_id=:bockId order by clazz_name", countQuery = "select clazz_id as clazzId, clazz_name as clazzName from clazz where block_id=:bockId order by clazz_name", nativeQuery = true)
    List<IClazz> showListClazz(@Param("bockId") Long bockId);


    /**
     * Create by NamHH
     * Date 01/03/2023
     * Function: showClazz
     **/
    @Query(value = "select clazz_id as clazzId, clazz_name as clazzName from clazz where clazz_id=:clazzId", nativeQuery = true)
    IClazz showClazz(@Param("clazzId") Long clazzId);


    /**
     * Created by: TrungNQ
     * Date Created: 27/02/2023
     * * Description: get list year of the class
     */
    @Query(value = "select c.year as year from clazz c where c.flag_delete=false group by year order by year desc", nativeQuery = true)
    List<IClazzYear> getListYear();


    /**
     * Created by: TrungNQ
     * Date Created: 27/02/2023
     * * Description: get list class name by param
     */
    @Query(value = "select c.clazz_id as id,c.clazz_name as name from clazz c where flag_delete=false and year=:year and clazz_name like concat(:name,'%') order by c.clazz_name", nativeQuery = true)
    List<IClazzName> getListClazzName(@Param("year") int year, @Param("name") String name);


    /**
     * Created by: TrungNQ
     * Date Created: 27/02/2023
     * * Description: get name class and name teacher of class
     */
    @Transactional
    @Query(value = "select c.clazz_id as id,c.clazz_name as name,c.school_year as schoolYear,t.teacher_id as teacherId,t.teacher_name as teacherName from clazz c join teacher t on c.teacher_id=t.teacher_id where (c.year=:year and c.clazz_id=:clazzId and c.flag_delete=false)", nativeQuery = true)
    IClazzTeacher getClazzTeacher(@Param("year") int year, @Param("clazzId") Long clazzId);


    /**
     * Created by: TrungNQ
     * Date Created: 27/02/2023
     * * Description: edit teacher of class by id
     */
    @Transactional
    @Modifying
    @Query(value = "update clazz set teacher_id =:teacherId where (clazz_id =:clazzId and flag_delete=false)", nativeQuery = true)
    void editTeacher(@Param("teacherId") Long teacherId, @Param("clazzId") Long clazzId);


    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     */
    @Query(value = "select * from clazz c where c.clazz_id=:clazzId and flag_delete=false", nativeQuery = true)
    Clazz getClazzById(@Param("clazzId") Long clazzId);

     /** create: HoangNM
     * @return
     */
    @Query(value = "select c.* from clazz as c", nativeQuery = true)
    List<Clazz> getAll();

    /**
     * Create by TuanNDN
     * @return
     */
    @Query(value =
            "SELECT `clazz`.clazz_id       as clazzId,\n" +
                    "       `clazz`.clazz_name     as clazzName,\n" +
                    "       `teacher`.teacher_id   as teacherId,\n" +
                    "       `teacher`.teacher_name as teacherName,\n" +
                    "       `block`.block_name     as blockName\n" +
                    "FROM `clazz`\n" +
                    "         left join `teacher` on `clazz`.teacher_id = `teacher`.teacher_id\n" +
                    "         left join `block` on `clazz`.block_id = `block`.block_id\n" +
                    "where clazz_id = :clazzId\n" +
                    "  and clazz.flag_delete = false\n" +
                    "order by clazz.clazz_name asc"
            ,countQuery =
            "SELECT `clazz`.clazz_id       as clazzId,\n" +
                    "       `clazz`.clazz_name     as clazzName,\n" +
                    "       `teacher`.teacher_id   as teacherId,\n" +
                    "       `teacher`.teacher_name as teacherName,\n" +
                    "       `block`.block_name     as blockName\n" +
                    "FROM `clazz`\n" +
                    "         left join `teacher` on `clazz`.teacher_id = `teacher`.teacher_id\n" +
                    "         left join `block` on `clazz`.block_id = `block`.block_id\n" +
                    "where clazz_id = :clazzId\n" +
                    "  and clazz.flag_delete = false\n" +
                    "order by clazz.clazz_name asc"
            ,nativeQuery = true)
    ClazzStudentDto findByIdClazzStudentDto(@Param("clazzId") Long clazzId);

    @Query(value =
            "SELECT `clazz`.clazz_id as clazzId," +
                    " `clazz`.clazz_name as clazzName," +
                    " `teacher`.teacher_id as teacherId," +
                    " `teacher`.teacher_name as teacherName," +
                    " `block`.block_name as blockName" +
                    " FROM  `clazz`" +
                    " left join `teacher` on `clazz`.teacher_id = `teacher`.teacher_id" +
                    " left join `block` on `clazz`.block_id = `block`.block_id" +
                    " where clazz.clazz_name like concat('%', :keySearch1 ,'%')" +
                    " and clazz.flag_delete=false"+
                    " order by clazz.clazz_name asc"
            ,countQuery =
            "SELECT `clazz`.clazz_id as clazzId," +
                    " `clazz`.clazz_name as clazzName," +
                    " `teacher`.teacher_id as teacherId," +
                    " `teacher`.teacher_name as teacherName," +
                    " `block`.block_name as blockName" +
                    " FROM  `clazz`" +
                    " left join `teacher` on `clazz`.teacher_id = `teacher`.teacher_id" +
                    " left join `block` on `clazz`.block_id = `block`.block_id" +
                    " where clazz.clazz_name like concat('%', :keySearch1 ,'%')" +
                    " and clazz.flag_delete=false" +
                    " order by clazz.clazz_name asc"
            ,nativeQuery = true)
    Page<ClazzStudentDto> findAllClazzStudentDto(Pageable pageable, @Param("keySearch1") String keySearch1);

    /**
     * TuanNDN
     * @return
     */
    @Query(value =
            "SELECT `clazz`.clazz_id as clazzId," +
                    "                     `clazz`.clazz_name as clazzName," +
                    "                     `teacher`.teacher_id as teacherId," +
                    "                     `teacher`.teacher_name as teacherName," +
                    "                     `block`.block_name as blockName" +
                    "                     FROM  `clazz`" +
                    "                     left join `teacher` on `clazz`.teacher_id = `teacher`.teacher_id" +
                    "                     left join `block` on `clazz`.block_id = `block`.block_id" +
                    "                     where clazz.flag_delete=false" +
                    "                     order by clazz.clazz_name asc"
            ,countQuery =
            "SELECT `clazz`.clazz_id as clazzId," +
                    "                     `clazz`.clazz_name as clazzName," +
                    "                     `teacher`.teacher_id as teacherId," +
                    "                     `teacher`.teacher_name as teacherName," +
                    "                     `block`.block_name as blockName" +
                    "                     FROM  `clazz`" +
                    "                     left join `teacher` on `clazz`.teacher_id = `teacher`.teacher_id" +
                    "                     left join `block` on `clazz`.block_id = `block`.block_id" +
                    "                     where clazz.flag_delete=false" +
                    "                     order by clazz.clazz_name asc"
            ,nativeQuery = true)
    List<ClazzStudentDto> findAllClazzStudentDtoNoPage();

}
