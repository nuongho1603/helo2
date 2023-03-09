package com.c0822g1primaryschoolbe.service.impl;

import com.c0822g1primaryschoolbe.dto.ITeacherDto;
import com.c0822g1primaryschoolbe.dto.teacher.TeacherDtoToSearch;
import com.c0822g1primaryschoolbe.dto.teacher.ITeacherDtoTuan;
import com.c0822g1primaryschoolbe.dto.teacher.ITeacherInfo;
import com.c0822g1primaryschoolbe.entity.teacher.Teacher;
import com.c0822g1primaryschoolbe.repository.ITeacherRepository;
import com.c0822g1primaryschoolbe.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.c0822g1primaryschoolbe.dto.teacher.TeacherViewDto;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {
    @Autowired
    private ITeacherRepository iTeacherRepository;

    /**
     * Create by: TrungNQ
     *
     * @param year
     * @return
     */
    @Override
    public List<ITeacherInfo> getListNameTeacher(int year) {
        return iTeacherRepository.getListNameTeacher(year);
    }

    @Override
    public ITeacherInfo getNameTeacher(String idCard, int year) {
        return iTeacherRepository.getNameTeacher(idCard, year);
    }


    @Override
    public TeacherViewDto findIdTeacher(Long accountId) {
        return iTeacherRepository.findIdTeacher(accountId);

    }

    @Override
    public com.c0822g1primaryschoolbe.dto.teacher.ITeacherDto findByTeacherDto(Long teacherId) {
        return iTeacherRepository.findByTeacherDto(teacherId);
    }


    /**
     * Created by: MinhCDK
     * Date created: 28/02/2023
     * Function: editInfoTeacher
     */

    @Override
    public void editInfoTeacher(String email, String phoneNumber, String address, Long teacherId) {
        iTeacherRepository.editInfoTeacher(email, phoneNumber, address, teacherId);
    }


    /**
     * create by : VinhLD
     * date create 27/02/2023
     * function: search teacher by name and status
     *
     * @param teacherDtoToSearch
     * @param pageable
     * @return
     */
    @Override
    public Page<ITeacherDto> searchTeacher(TeacherDtoToSearch teacherDtoToSearch, Pageable pageable) {
        return iTeacherRepository.searchTeacher(teacherDtoToSearch, pageable);
    }

    /**
     * Create by TuanNDN
     *
     * @param teacherId
     * @return
     */
    @Override
    public Optional<Teacher> findByIdTeacher(Long teacherId) {
        return iTeacherRepository.findByIdTeacher(teacherId);
    }

    /**
     * Create by TuanNDN
     *
     * @return
     */
    @Override
    public List<ITeacherDtoTuan> showListTeacher() {
        return iTeacherRepository.showListTeacher();
    }
}
