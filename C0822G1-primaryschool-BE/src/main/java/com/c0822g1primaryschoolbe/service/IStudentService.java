package com.c0822g1primaryschoolbe.service;

import com.c0822g1primaryschoolbe.dto.clazz.StudentClazzDto;
import com.c0822g1primaryschoolbe.dto.student.IStudentDto;
import com.c0822g1primaryschoolbe.dto.student.StudentDtoToSearch;
import com.c0822g1primaryschoolbe.entity.student.Student;
import com.c0822g1primaryschoolbe.dto.student.IStudentInfo;
import com.c0822g1primaryschoolbe.dto.student.StudentListViewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

import java.util.List;

public interface IStudentService {
    /**
     * Create by TuanNDN
     * @return
     */
    List<Student> showListStudent();

    /**
     * Create by TuanNDN
     * @param classId
     * @return
     */

    /**
     * Create by TuanNDN
     * @param classId
     * @return
     */
    List<Student> findAllStudentByClassId(Integer classId);

    /**
     * Create by TuanNDN
     * @param list
     */
    void changeClazzId(List<Long> list);

    /**
     * Create by TuanNDN
     * @param idList
     * @return
     */
    List<Student> findByListStudentId( List<Long> idList);

    /**
     * Create by TuanNDN
     */
    void upClassNew();

    /**
     * Create by TuanNDN
     */
    void lockUpClass();


    /**
     * Create by : TrungNQ
     * Date create: 27/02/2023
     */
    Page<IStudentInfo> getStudentList(Pageable pageable, int year, Long clazzId);

    /**
     * Create by : TrungNQ
     * Date create: 27/02/2023
     */
    void removeStudent(Long id);

    /**
     * Create by : NuongHT
     * Date create: 27/02/2023
     */
    Student getStudentById(Long id);

    /**
     * Create by : HoangNM
     * Date create: 27/02/2023
     */
    void create(Student student);

    /**
     * Create by : HoangNM
     * Date create: 27/02/2023
     */
    Student findId(long studentId);

    void update(Student student);

    /**
     * Created by: VanNTC
     * Date Created: 27/02/2023
     * * Description: get student list of the class
     */
    Page<StudentListViewDto> showAllStudent(Long teacherId, Pageable pageable);

    /**
     * Create by : NuongHT
     * Date create: 27/02/2023
     */
    Optional<Student> findById(Long id);

    Page<Student> findByName(String name, String status, Pageable pageable);


    Page<IStudentDto> findByNameAndStatus(String name, Boolean status, Pageable pageable);

    /**
     * create by :VinhLD
     * date create 27/02/2023
     * funtion : search student by name and status
     *
     * @param "name, status"
     * @return
     */
    Page<IStudentDto> searchStudent(StudentDtoToSearch studentDtoToSearch, Pageable pageable);

    /**
     * Create by TuanNDN
     */
    List<StudentClazzDto> findAllStudentClazzDto(Integer clazzId);
}


