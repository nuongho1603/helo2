package com.c0822g1primaryschoolbe.service.impl;

import com.c0822g1primaryschoolbe.dto.time_table.TimeTableView;
import com.c0822g1primaryschoolbe.dto.time_table.ITimetable;

import com.c0822g1primaryschoolbe.repository.ITimeTableRepository;
import com.c0822g1primaryschoolbe.service.ITimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTableService implements ITimetableService {
    @Autowired
    private ITimeTableRepository timeTableRepository;
    /**
     * Created by: VanNTC
     * Date Created: 27/02/2023
     *  * Description: get time table of the class by id
     */
    @Override
    public List<TimeTableView> getTimeTableByIdTeacher(String teacherId) {
        return timeTableRepository.getAllByIdTeacher(teacherId);
    }

    /**
     * Create by : NamHH
     * Date created: 27/02/2023
     * Function: get all timetable where id_clazz
     *
     * @Param idClazz
     */
    @Override
    public List<ITimetable>getAllTimetable(Long idClazz) {
        return timeTableRepository.getAllTimetable(idClazz);
    }


    /**
     * Create by : NamHH
     * Date created: 28/02/2023
     * Function: update timetable where id_subject
     *
     * @Param id_timetable, id_subject
     */
    @Override
    public void updateTimetable(Long idTimetable, Long idSubject) {
        timeTableRepository.updateTimetable(idTimetable, idSubject);
    }


}
