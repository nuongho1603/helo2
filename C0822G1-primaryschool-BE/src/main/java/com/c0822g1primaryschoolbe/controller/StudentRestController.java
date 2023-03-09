package com.c0822g1primaryschoolbe.controller;

import com.c0822g1primaryschoolbe.dto.clazz.*;
import com.c0822g1primaryschoolbe.entity.clazz.*;
import com.c0822g1primaryschoolbe.dto.student.IStudentInfo;
import com.c0822g1primaryschoolbe.entity.student.Student;
import com.c0822g1primaryschoolbe.dto.teacher.ITeacherInfo;
import com.c0822g1primaryschoolbe.service.IClazzService;
import com.c0822g1primaryschoolbe.service.IStudentService;
import com.c0822g1primaryschoolbe.service.ITeacherService;
import com.c0822g1primaryschoolbe.dto.student.StudentDto;
import com.c0822g1primaryschoolbe.dto.student.StudentListViewDto;
import com.c0822g1primaryschoolbe.dto.teacher.TeacherViewDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentRestController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private ITeacherService teacherService;

    @Autowired
    private IClazzService clazzService;

    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     * Funciton: get Page Student by Param
     *
     * @param year,
     * @param clazzId
     * @param pageable
     * @return HttpStatus.NO_CONTENT if rerult is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/list")
    public ResponseEntity<Page<IStudentInfo>> getStudentList(@PageableDefault(size = 10) Pageable pageable, @RequestParam String year, @RequestParam String clazzId) {
        Page<IStudentInfo> iStudentInfos = studentService.getStudentList(pageable, Integer.parseInt(year), Long.parseLong(clazzId));
        if (iStudentInfos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iStudentInfos, HttpStatus.OK);
    }

    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     * Funciton: get List Year
     *
     * @return HttpStatus.NO_CONTENT if rerult is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/year")
    public ResponseEntity<List<IClazzYear>> getListYear() {
        List<IClazzYear> iClazzYears = clazzService.getListYear();
        if (iClazzYears.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iClazzYears, HttpStatus.OK);
    }

    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     * Funciton: get List Clazz Name by Param
     *
     * @param year
     * @param name
     * @return HttpStatus.NO_CONTENT if rerult is error or HttpStatus.OK if result is not error
     */
    @GetMapping()
    public ResponseEntity<List<IClazzName>> getListClazzName(@RequestParam("year") String year, @RequestParam("name") String name) {
        List<IClazzName> iClazzNames = clazzService.getListClazzName(Integer.parseInt(year), name);
        if (iClazzNames.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iClazzNames, HttpStatus.OK);
    }

    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     * Funciton: get info Clazz and Teacher by Param
     *
     * @param year
     * @param clazzId
     * @return HttpStatus.NO_CONTENT if rerult is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/clazz")
    public ResponseEntity<IClazzTeacher> getClazzTeacher(@RequestParam String year, @RequestParam String clazzId) {
        IClazzTeacher iClazzTeacher = clazzService.getClazzTeacher(Integer.parseInt(year), Long.parseLong(clazzId));
        if (iClazzTeacher == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iClazzTeacher, HttpStatus.OK);
    }

    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     * Funciton: get list teacher name by Param
     *
     * @param year
     * @return HttpStatus.NO_CONTENT if rerult is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/teacher-name-list")
    public ResponseEntity<List<ITeacherInfo>> getListNameTeacher(@RequestParam String year) {
        List<ITeacherInfo> iTeacherInfos = teacherService.getListNameTeacher(Integer.parseInt(year));
        if (iTeacherInfos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iTeacherInfos, HttpStatus.OK);
    }

    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     * Funciton: get teacher name by Param
     *
     * @param year
     * @param idCard
     * @return HttpStatus.NO_CONTENT if rerult is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/teacher-name")
    public ResponseEntity<ITeacherInfo> getNameTeacher(@RequestParam String idCard, @RequestParam String year) {
        ITeacherInfo iTeacherInfo = teacherService.getNameTeacher(idCard, Integer.parseInt(year));
        if (iTeacherInfo == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iTeacherInfo, HttpStatus.OK);
    }


    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     * Funciton: edit teacherId by idClazz
     *
     * @param clazzId
     * @param clazzTeacherDto
     * @return HttpStatus.BAD_REQUEST if rerult is error or HttpStatus.OK if result is not error
     */
    @PutMapping("/edit-teacher/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ClazzTeacherDto> editTeacher(@RequestBody ClazzTeacherDto clazzTeacherDto, @PathVariable("id") Long clazzId) {
        Clazz clazz = clazzService.getClazzById(clazzId);
        if (clazz == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        clazzService.editTeacher(clazzTeacherDto.getTeacherId(), clazzId);
        return new ResponseEntity<>(clazzTeacherDto, HttpStatus.OK);
    }

    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     * Funciton: delete student by id
     * @param id
     * @return HttpStatus.NO_CONTENT if rerult is error or HttpStatus.OK if result is not error
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        studentService.removeStudent(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    /**
     * Create by : VanNTC
     * Date create: 27/02/2023
     * Description: take student list by id teacher
     *
     * @param pageable
     * @return
     */

    @GetMapping("/list-id-teacher/{teacherId}")
    public ResponseEntity<Page<StudentListViewDto>> getAllStudentByIdTeacher(@PageableDefault(size = 10) Pageable pageable, @PathVariable Long teacherId) {
        Page<StudentListViewDto> studentListViewDtoPage = studentService.showAllStudent(teacherId, pageable);
        if (studentListViewDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentListViewDtoPage, HttpStatus.OK);
    }

    /**
     * Create by : VanNTC
     * Date create: 27/02/2023
     * Description: get teacherID by accountId
     *
     * @param accountId
     * @return teacherId
     */

    @GetMapping("/find-teacher/{accountId}")
    public ResponseEntity<TeacherViewDto> getTeacher(@PathVariable("accountId") Long accountId){
        TeacherViewDto teacherViewDto = this.teacherService.findIdTeacher(accountId);
        return new ResponseEntity<>(teacherViewDto, HttpStatus.OK);
    }


    /**
     * Create by : NuongHT
     * Date create: 27/02/2023
     * Description: get student by studentID
     *
     * @param 'studentID'
     * @return student
     */
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_TEACHER')")
    public ResponseEntity<Student> getInfoStudent(@PathVariable Long id) {
        Student student = studentService.findById(id).orElse(null);
        if(student == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    /**
     * Create by: HoangNM
     * Date created: 27/02/2023
     * Function: find Student by id
     *
     * @param studentId
     * @return student,HttpStatus.OK
     */
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> findByIdStudent(@PathVariable Long studentId){
        Student student = this.studentService.findId(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    /**
     * Create by: HoangNM,
     * Date created: 27/02/2023
     * Function: create Student by id
     *
     * @param studentDto
     * @param bindingResult
     * @return HttpStatus.OK
     */
    @PostMapping(value = "/create-student")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> createStudent(@RequestBody @Valid StudentDto studentDto, BindingResult bindingResult) {
        System.out.println(studentDto);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        Clazz clazz = new Clazz();
        clazz.setClazzId(studentDto.getClazzDto().getClazzId());
        student.setClazz(clazz);

        studentService.create(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: HoangNM,
     * Date created: 27/02/2023
     * Function: update Student by id
     *
     * @param studentDto
     * @param bindingResult
     * @return HttpStatus.OK
     */
    @PutMapping("/update-student")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> updateStudent(@RequestBody @Valid StudentDto studentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        ClazzDto clazzDto = studentDto.getClazzDto();
        Clazz clazz = new Clazz();
        BeanUtils.copyProperties(clazzDto,clazz);
//        clazz.setClazzId(studentDto.getClazzDto().getClazzId());
        student.setClazz(clazz);
        studentService.update(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
