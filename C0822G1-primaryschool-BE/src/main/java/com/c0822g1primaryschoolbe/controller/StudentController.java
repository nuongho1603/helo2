package com.c0822g1primaryschoolbe.controller;


import com.c0822g1primaryschoolbe.dto.student.IStudentDto;
import com.c0822g1primaryschoolbe.dto.student.StudentDtoToSearch;
import com.c0822g1primaryschoolbe.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;


/**
 * create by :VinhLD
 * date create 27/02/2023
 * <p>
 * funtion : search student by name and status
 *
 * @param "name, status"
 * @return httpStatus.Notfound if result is error or HttpStatus.Ok if result is not error
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    /**
     *  create by :VinhLD
     *  date create 27/02/2023
      *function : search student by name and status
     * @param studentDtoToSearch
     * @param pageable
     * @return
     */
    @PostMapping("/search")
    public ResponseEntity<Page<IStudentDto>> searchStudent(@RequestBody StudentDtoToSearch studentDtoToSearch,
                                                             @PageableDefault(value = 5) Pageable pageable) {
        if (studentDtoToSearch == null || ObjectUtils.isEmpty(studentDtoToSearch)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Page<IStudentDto> studentPage = studentService.searchStudent(studentDtoToSearch, pageable);
        if (studentPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentPage, HttpStatus.OK);
    }

}
