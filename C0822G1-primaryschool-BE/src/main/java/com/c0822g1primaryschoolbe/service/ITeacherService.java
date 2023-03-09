package com.c0822g1primaryschoolbe.service;
import com.c0822g1primaryschoolbe.dto.ITeacherDto;
import com.c0822g1primaryschoolbe.dto.teacher.TeacherDtoToSearch;
import com.c0822g1primaryschoolbe.dto.teacher.ITeacherDtoTuan;
import com.c0822g1primaryschoolbe.entity.teacher.Teacher;
import org.springframework.data.repository.query.Param;
import com.c0822g1primaryschoolbe.dto.teacher.TeacherViewDto;
import com.c0822g1primaryschoolbe.dto.teacher.ITeacherInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface ITeacherService {
    /**
     * Create by TuanNDN
     * @param teacherId
     * @return
     */
    Optional<Teacher> findByIdTeacher(@Param("teacherId") Long teacherId);

    /**
     * Create by TuanNDN
     * @return
     */

    List<ITeacherDtoTuan> showListTeacher();

    List<ITeacherInfo> getListNameTeacher(int year);

    ITeacherInfo getNameTeacher(String idCard,int year);

    /**
     * Create by : VanNTC
     * Date create: 27/02/2023
     * Description: take teacher by id Account
     * @param accountId
     * *return Teacher
     **/
    TeacherViewDto findIdTeacher(Long accountId);

    /**
     * Created by: MinhCDK
     * Date created: 28/02/2023
     * Function: findByTeacher
     */
    com.c0822g1primaryschoolbe.dto.teacher.ITeacherDto findByTeacherDto(Long teacherId);

    /**
     * Created by: MinhCDK
     * Date created: 28/02/2023
     * Function: editInfoTeacher
     */
    void editInfoTeacher(String email, String phoneNumber, String address, Long teacherId);

    /**
     * create by : VinhLD
     * date create 27/02/2023
     * function : search  teacher by name and status
     *
     * @param teacherDtoToSearch
     * @param pageable
     * @return
     */
    Page<ITeacherDto> searchTeacher(TeacherDtoToSearch teacherDtoToSearch, Pageable pageable);
}
