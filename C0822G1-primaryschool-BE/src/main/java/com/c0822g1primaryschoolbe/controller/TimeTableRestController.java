package com.c0822g1primaryschoolbe.controller;

import com.c0822g1primaryschoolbe.dto.time_table.TimeTableView;
import com.c0822g1primaryschoolbe.dto.time_table.IClazz;
import com.c0822g1primaryschoolbe.dto.time_table.ITimetable;
import com.c0822g1primaryschoolbe.dto.time_table.ITimetableUpdate;
import com.c0822g1primaryschoolbe.entity.time_table_subject.Subject;
import com.c0822g1primaryschoolbe.service.IClazzService;
import com.c0822g1primaryschoolbe.service.ITimetableService;
import com.c0822g1primaryschoolbe.service.subject.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetable")
@CrossOrigin("*")
public class TimeTableRestController {
    @Autowired
    private ITimetableService timetableService;

    @Autowired
    private ISubjectService subjectService;

    @Autowired
    private IClazzService clazzService;


    /**
     * Create by : NamHH
     * Date created: 27/02/2023
     * Function: get all timetable where id_clazz
     *
     * @Param idClazz
     * @Return HttpStatus.NO_CONTENT if result is error or HttpStatus.OK if result is not error
     */
    @GetMapping(value = "/list-timetable/{idClazz}")
    public ResponseEntity<List<ITimetable>> getAllTimetable(@PathVariable("idClazz") Long idClazz) {
        List<ITimetable> listTimetable = timetableService.getAllTimetable(idClazz);
        if (listTimetable.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listTimetable, HttpStatus.OK);
    }


    /**
     * Create by : NamHH
     * Date created: 27/02/2023
     * Function: update subject_id in timetable where id_timetable
     *
     * @Return HttpStatus.BAD_REQUEST if result is error or HttpStatus.OK if result is not error
     */
    @PutMapping(value = "/update-timetable")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> updateTimetableSubject(@RequestBody List<ITimetableUpdate> iTimetableUpdates) {
        for (ITimetableUpdate iTimetableUpdate : iTimetableUpdates) {
            if (iTimetableUpdate == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            timetableService.updateTimetable(iTimetableUpdate.getTimetableId(), iTimetableUpdate.getSubjectId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Create by : NamHH
     * Date created: 28/02/2023
     * Function: get all subject
     *
     * @Return HttpStatus.NO_CONTENT if result is error or HttpStatus.OK if result is not error
     */
    @GetMapping(value = "/list-subject")
    public ResponseEntity<List<Subject>> findAllSubject() {
        List<Subject> subjectList = subjectService.findAllSubject();
        if (subjectList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(subjectList, HttpStatus.OK);
    }


    /**
     * Create by : NamHH
     * Date created: 01/03/2023
     * Function: get all clazz
     *
     * @Return HttpStatus.NO_CONTENT if result is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/list-clazz/{bockId}")
    public ResponseEntity<List<IClazz>> showListClazz(@PathVariable("bockId") Long bockId) {
        List<IClazz> clazzList = clazzService.showListClazz(bockId);
        if (clazzList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(clazzList, HttpStatus.OK);
    }


    /**
     * Create by : NamHH
     * Date created: 01/03/2023
     * Function: get clazz
     *
     * @Return HttpStatus.NO_CONTENT if result is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/object-clazz/{clazzId}")
    public ResponseEntity<IClazz> showClazz(@PathVariable("clazzId") Long clazzId) {
        IClazz iClazz = clazzService.showClazz(clazzId);
        if (iClazz == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iClazz, HttpStatus.OK);
    }

    /**
     * Created by: VanNTC
     * Date Created: 27/02/2023
     * * Description: get time table of the class by id
     */
    @GetMapping("/{teacherId}")
    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    public ResponseEntity<List<TimeTableView>> showTimeTable(@PathVariable String teacherId) {
        List<TimeTableView> timeTable = timetableService.getTimeTableByIdTeacher(teacherId);
        if (timeTable.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(timeTable, HttpStatus.OK);
    }
}