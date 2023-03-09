package com.c0822g1primaryschoolbe.service.impl;

import com.c0822g1primaryschoolbe.dto.clazz.ClazzStudentDto;
import com.c0822g1primaryschoolbe.dto.clazz.IClazzName;
import com.c0822g1primaryschoolbe.dto.clazz.IClazzTeacher;
import com.c0822g1primaryschoolbe.dto.clazz.IClazzYear;
import com.c0822g1primaryschoolbe.entity.clazz.*;
import com.c0822g1primaryschoolbe.entity.clazz.Clazz;
import com.c0822g1primaryschoolbe.dto.time_table.IClazz;
import com.c0822g1primaryschoolbe.repository.IBlockRepository;
import com.c0822g1primaryschoolbe.repository.IClazzRepository;
import com.c0822g1primaryschoolbe.repository.ITeacherRepository;
import com.c0822g1primaryschoolbe.service.IClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzService implements IClazzService {
    @Autowired
    private IClazzRepository clazzRepository;

    @Autowired
    private ITeacherRepository teacherRepository;

    @Autowired
    private IBlockRepository blockRepository;

    /**
     * Create by : TrungNQ
     * Date create: 27/02/2023
     */
    @Override
    public List<IClazzYear> getListYear() {
        return clazzRepository.getListYear();
    }


    /**
     * Create by : TrungNQ
     * Date create: 27/02/2023
     */
    @Override
    public List<IClazzName> getListClazzName(int year, String name) {
        return clazzRepository.getListClazzName(year,name);
    }


    /**
     * Create by : TrungNQ
     * Date create: 27/02/2023
     */
    @Override
    public IClazzTeacher getClazzTeacher(int year, Long clazzId) {
        return clazzRepository.getClazzTeacher(year,clazzId);
    }


    /**
     * Create by : TrungNQ
     * Date create: 27/02/2023
     */
    @Override
    public void editTeacher(Long teacherId, Long clazzId) {
        clazzRepository.editTeacher(teacherId,clazzId);
    }


    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     */
    @Override
    public Clazz getClazzById(Long clazzId) {
        return clazzRepository.getClazzById(clazzId);
    }


    /**
     * Create by : HoangNM
     * Date create: 27/02/2023
     */
    @Override
    public List<Clazz> getAll() {
        return clazzRepository.getAll();
    }

    @Override
    public Clazz findByIdClazzStudent(Long studentId) {
        return clazzRepository.findByIdClazzStudent(studentId);
    }

    @Override
    public ClazzStudentDto findByIdClazzStudentDto(Long clazzId) {
        return clazzRepository.findByIdClazzStudentDto(clazzId);
    }

    @Override
    public Page<ClazzStudentDto> findAllClazzStudentDto(Pageable pageable, String keySearch1) {
        return clazzRepository.findAllClazzStudentDto(pageable, keySearch1);
    }

    @Override
    public List<ClazzStudentDto> findAllClazzStudentDtoNoPage() {
        return clazzRepository.findAllClazzStudentDtoNoPage();
    }


    /**
     * Create by TuanNDN
     * @param pageable
     * @param keySearch1
     * @return
     */
    @Override
    public Page<Clazz> findAllClazz(Pageable pageable, String keySearch1) {
        return clazzRepository.findAllClazz(pageable, keySearch1);
    }

    /**
     * Create by TuanNDN
     * @param clazzId
     * @return
     */
    @Override
    public Clazz findByIdClazz(Long clazzId) {
        return clazzRepository.findByIdClazz(clazzId);
    }

    /**
     * Create by TuanNDN
     * @param clazz
     */
    @Override
    public void updateClazz(Clazz clazz) {
        clazzRepository.updateClazz(
                clazz.getClazzId(),
                clazz.getTeacher().getTeacherId(),
                clazz.getClazzName(),
                clazz.getFlagDelete(),
                clazz.getSchoolYear(),
                clazz.getYear(),
                clazz.getBlock().getBlockId());
    }

    /**
     * Create by TuanNDN
     */
    @Override
    public void upBlockNew() {
        clazzRepository.upBlockNew();
    }


    /** Method use: createChooseClass()
     * Created date: 27/02/2023
     * Function:showListAll
     * Parameter: contentClass
     * Author: DungND
     * */
    @Override
    public List<ClazzStudentDto> showListAll() {
        return clazzRepository.showListAll();
    }

    /** Method use: createChooseClass()
     * Created date: 27/02/2023
     * Function:createChooseClass
     * Parameter: contentClass
     * Author: DungND
     * */
    @Override
    public void createChooseClass(Clazz clazz) {
        Long a = Long.parseLong(String.valueOf(clazz.getClazzName().trim().charAt(0)));
        Block block = new Block(a);
        clazz.setBlock(block);
        clazzRepository.createChooseClass(clazz.getClazzName(),clazz.getSchoolYear(),clazz.getBlock(),clazz.getTeacher(),clazz.getYear());
    }

    /**
     * create by : DungND
     * Data create: 27/02/2023
     * funcion: showListClassStudentById()
     * @param 'id'
     */
    @Override
    public List<ClazzStudentDto> showListClassStudentById(long id) {
        return clazzRepository.showListClassStudentById(id);
    }

    /**
     * Create by NamHH
     * Date 01/03/2023
     * Function: showListClazz
     **/
    @Override
    public List<IClazz> showListClazz(Long bockId) {
        return clazzRepository.showListClazz(bockId);
    }


    /**
     * Create by NamHH
     * Date 01/03/2023
     * Function: showClazz
     **/
    @Override
    public IClazz showClazz(Long clazzId) {
        return clazzRepository.showClazz(clazzId);
    }

}
