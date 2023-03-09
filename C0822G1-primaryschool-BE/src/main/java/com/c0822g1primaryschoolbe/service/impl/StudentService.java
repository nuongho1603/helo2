package com.c0822g1primaryschoolbe.service.impl;

import com.c0822g1primaryschoolbe.dto.clazz.StudentClazzDto;
import com.c0822g1primaryschoolbe.dto.student.IStudentInfo;
import com.c0822g1primaryschoolbe.dto.student.StudentListViewDto;
import com.c0822g1primaryschoolbe.entity.student.Student;
import com.c0822g1primaryschoolbe.repository.IStudentRepository;


import com.c0822g1primaryschoolbe.dto.student.IStudentDto;
import com.c0822g1primaryschoolbe.dto.student.StudentDtoToSearch;

import com.c0822g1primaryschoolbe.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;


    @Override
    public Page<IStudentInfo> getStudentList(Pageable pageable, int year, Long clazzId) {
        return studentRepository.getStudentList(pageable, year, clazzId);
    }

    @Override
    public void removeStudent(Long id) {
        studentRepository.removeStudent(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }


    /**
     * Create by : HoangNM
     * Date create: 27/02/2023
     */
    @Override
    public void create(Student student) {
        studentRepository.createStudent(student);
    }

    @Override
    public Student findId(long studentId) {
        return studentRepository.findId(studentId);
    }

    @Override
    public void update(Student student) {
        studentRepository.updateStudent(student);
    }

    /**
     * Create by : VanNTC
     * Date create: 27/02/2023
     */

    @Override
    public Page<StudentListViewDto> showAllStudent(Long teacherId, Pageable pageable) {
        return studentRepository.showAllStudent(teacherId, pageable);

        /**
         * Create by : NuongHT
         * Date create: 28/02/2023
         * Description: repository call database
         *
         **/
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Page<Student> findByName(String name, String status, Pageable pageable) {
        return studentRepository.findByName(name, status, pageable);
    }

    @Override
    public Page<IStudentDto> findByNameAndStatus(String name, Boolean status, Pageable pageable) {
        return studentRepository.findByNameAndStatus(name, status, pageable);
    }

    /**
     * create by :VinhLD
     * date create 27/02/2023
     * funtion : search student by name and status
     *
     * @param "name, status"
     * @return
     */
    @Override
    public Page<IStudentDto> searchStudent(StudentDtoToSearch studentDtoToSearch, Pageable pageable) {
        return studentRepository.searchStudent(studentDtoToSearch, pageable);
    }

    /**
     * Create by TuanNDN
     *
     * @return
     */
    @Override
    public List<StudentClazzDto> findAllStudentClazzDto(Integer clazzId) {
        return studentRepository.findAllStudentClazzDto(clazzId);
    }

    /**
     * Create by TuanNDN
     *
     * @return
     */
    @Override
    public List<Student> showListStudent() {
        return studentRepository.showListStudent();
    }


    /**
     * Create by TuanNDN
     *
     * @param classId
     * @return
     */
    @Override
    public List<Student> findAllStudentByClassId(Integer classId) {
        return this.studentRepository.findAllStudentByClassId(classId);
    }

    /**
     * Create by TuanNDN
     *
     * @param list
     */
    @Override
    public void changeClazzId(List<Long> list) {
        studentRepository.changeClazzId(list);
    }

    /**
     * Create by TuanNDN
     *
     * @param idList
     * @return
     */
    @Override
    public List<Student> findByListStudentId(List<Long> idList) {
        return studentRepository.findByListStudentId(idList);
    }

    /**
     * Create by TuanNDN
     */
    @Override
    public void upClassNew() {
        studentRepository.upClassNew();
    }

    /**
     * Create by TuanNDN
     */
    @Override
    public void lockUpClass() {
        studentRepository.lockUpClass();

    }
}
