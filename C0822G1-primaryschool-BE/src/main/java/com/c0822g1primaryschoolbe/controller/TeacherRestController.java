package com.c0822g1primaryschoolbe.controller;

import com.c0822g1primaryschoolbe.dto.teacher.ITeacherDto;
import com.c0822g1primaryschoolbe.dto.teacher.TeacherDto;
import com.c0822g1primaryschoolbe.entity.teacher.Teacher;
import com.c0822g1primaryschoolbe.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/teacher")
@CrossOrigin("*")
public class TeacherRestController {
    @Autowired
    private ITeacherService iTeacherService;

    /**
     * Created by: MinhCDK
     * Date created: 28/02/2023
     * Function: editInfoTeacher
     */
    @PutMapping("editInfoTeacher")
    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    public ResponseEntity<?> editInfoTeacher(@Validated @RequestBody TeacherDto teacherDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        iTeacherService.editInfoTeacher(teacherDto.getEmail(), teacherDto.getPhoneNumber(), teacherDto.getAddress(), teacherDto.getTeacherId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: MinhCDK
     * Date created: 03/03/2023
     */

    @GetMapping("/{teacherId}")
    public ResponseEntity<?> findByTeacherId(@PathVariable("teacherId") Long teacherId) {
        ITeacherDto iTeacherDto = iTeacherService.findByTeacherDto(teacherId);
        if (teacherId == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iTeacherDto, HttpStatus.OK);
    }


}
