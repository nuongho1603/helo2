package com.c0822g1primaryschoolbe.controller;

import com.c0822g1primaryschoolbe.dto.ITeacherDto;

import com.c0822g1primaryschoolbe.dto.teacher.TeacherDtoToSearch;

import com.c0822g1primaryschoolbe.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;

    /**
     * create by VinhLD
     * date create 27/02/2023
     * function : search teacher by name and status
     * @param "teacherDtoToSearch"
     * @param "pageable"
     * @return
     */

     @PostMapping("/search")
    public ResponseEntity<Page<ITeacherDto>> searchTeacher(@RequestBody TeacherDtoToSearch teacherDtoToSearch,
                                                           @PageableDefault(value = 5) Pageable pageable){
        if (teacherDtoToSearch == null || ObjectUtils.isEmpty(teacherDtoToSearch)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Page<ITeacherDto> teacherPage = teacherService.searchTeacher(teacherDtoToSearch, pageable);
        if (teacherPage.isEmpty()) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teacherPage, HttpStatus.OK);
    }
}
