package com.c0822g1primaryschoolbe.service;

import com.c0822g1primaryschoolbe.dto.clazz.ClazzStudentDto;
import com.c0822g1primaryschoolbe.dto.clazz.IClazzName;
import com.c0822g1primaryschoolbe.dto.clazz.IClazzTeacher;
import com.c0822g1primaryschoolbe.dto.clazz.IClazzYear;
import com.c0822g1primaryschoolbe.entity.clazz.Clazz;
import com.c0822g1primaryschoolbe.dto.time_table.IClazz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IClazzService {
    /**
     * Create by TuanNDN
     * @param pageable
     * @param keySearch1
     * @return
     */
    Page<Clazz> findAllClazz(Pageable pageable, @Param("keySearch1") String keySearch1);

    /**
     * Create by TuanNDN
     * @param clazzId
     * @return
     */
    Clazz findByIdClazz(@Param("clazzId") Long clazzId);

    /**
     * Create by TuanNDN
     * @param clazz
     */
    void updateClazz(Clazz clazz);

    /**
     * Create by TuanNDN
     */
    void upBlockNew();

    /** Method use: createChooseClass()
     * Created date: 27/02/2023
     * Function:showListAll
     * Parameter: contentClass
     * Author: DungND
     */
    List<ClazzStudentDto> showListAll();

    /**
     * Method use: createChooseClass()
     * Created date: 27/02/2023
     * Function:createChooseClass
     * Parameter: contentClass
     * Author: DungND
     */
    void createChooseClass(Clazz clazz);

    /**
     * create by : DungND
     * Data create: 27/02/2023
     * funcion: showListClassStudentById()
     *
     * @param 'id'
     */
    List<ClazzStudentDto> showListClassStudentById(@Param("id") long id);

    /**
     * Create by: NamHH
     * Data create: 27/02/2023
     * funcion: getAllClass
     * @return
     * @Param id_block
     */

    List<IClazz> showListClazz(Long bockId);

    /**
     * Create by: NamHH
     * Data create: 28/02/2023
     * funcion: getClass
     *
     * @return
     * @Param id_clazz
     */
    IClazz showClazz(Long clazzId);

    /**
     * Create by : TrungNQ
     * Date create: 27/02/2023
     */
    List<IClazzYear> getListYear();

    /**
     * Create by : TrungNQ
     * Date create: 27/02/2023
     */
    List<IClazzName> getListClazzName(int year, String name);

    /**
     * Create by : TrungNQ
     * Date create: 27/02/2023
     */
    IClazzTeacher getClazzTeacher(int year, Long clazzId);

    /**
     * Create by : TrungNQ
     * Date create: 27/02/2023
     */
    void editTeacher(Long teacherId, Long clazzId);

    /**
     * Create by : TrungNQ
     * Date create: 27/02/2023
     */
    Clazz getClazzById(Long clazzId);

    /**
     * Create: HoangMN
     * @return
     */
    List<Clazz> getAll();

    /**
     * Create: HoangMN
     * @return
     */
    Clazz findByIdClazzStudent(Long studentId);

    ClazzStudentDto findByIdClazzStudentDto( Long clazzId);
    /**
     * Create by TuanNDN
     */
    Page<ClazzStudentDto> findAllClazzStudentDto(Pageable pageable,String keySearch1);
    /**
     * Create by TuanNDN
     */
    List<ClazzStudentDto> findAllClazzStudentDtoNoPage();
}
