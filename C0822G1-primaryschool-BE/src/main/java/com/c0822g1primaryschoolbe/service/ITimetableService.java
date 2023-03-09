package com.c0822g1primaryschoolbe.service;

import com.c0822g1primaryschoolbe.dto.time_table.TimeTableView;
import com.c0822g1primaryschoolbe.dto.time_table.ITimetable;

import java.util.List;

public interface ITimetableService {
    /**
     * Create by : NamHH
     * Date created: 27/02/2023
     * Function: get all timetable where id_clazz
     *
     * @Param idClazz
     */
    List<ITimetable> getAllTimetable(Long idClazz);



    /**
     * Create by : NamHH
     * Date created: 28/02/2023
     * Function: update timetable where id_subject
     *
     * @Param id_timetable, id_subject
     */
    void updateTimetable(Long idTimetable, Long idSubject);

    /**
     * Created by: VanNTC
     * Date Created: 27/02/2023
     *  * Description: get time table of the class by id
     */
    List<TimeTableView> getTimeTableByIdTeacher(String teacherId);
}
