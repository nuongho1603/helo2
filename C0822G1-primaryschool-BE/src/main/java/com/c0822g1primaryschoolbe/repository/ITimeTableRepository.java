package com.c0822g1primaryschoolbe.repository;

import com.c0822g1primaryschoolbe.dto.time_table.TimeTableView;
import com.c0822g1primaryschoolbe.entity.student.Student;
import com.c0822g1primaryschoolbe.dto.time_table.ITimetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ITimeTableRepository extends JpaRepository<Student, Long> {
    /**
     * Created by: VanNTC
     * Date Created: 27/02/2023
     * * Description: get list timetable of the class
     */

    @Query(value = "select tt.time_table_id as timeTableId, `lesson`.lesson_name as nameLesson, `day`.day_name as nameDay, `subject`.subject_name as nameSubject from `time_table` tt\n" +
            "join `day` on `day`.day_id = tt.day_id\n" +
            "join `lesson` on `lesson`.lesson_id = tt.lesson_id\n" +
            "join `subject` on tt.subject_id = `subject`.subject_id\n" +
            "join `clazz` on tt.clazz_id = `clazz`.clazz_id\n" +
            "join `teacher` t on t.teacher_id = `clazz`.teacher_id\n" +
            "where   t.teacher_id= :teacherId\n" +
            "order by `day`.day_name, `lesson`.lesson_name", nativeQuery = true, countQuery = "select tt.time_table_id as timeTableId, `lesson`.lesson_name, `day`.day_name, `subject`.subject_name from `time_table` tt\n" +
            "join `day` on `day`.day_id = tt.day_id\n" +
            "join `lesson` on `lesson`.lesson_id = tt.lesson_id\n" +
            "join `subject` on tt.subject_id = `subject`.subject_id\n" +
            "join `clazz` on tt.clazz_id = `clazz`.clazz_id\n" +
            "join `teacher` t on t.teacher_id = `clazz`.teacher_id\n" +
            "where   t.teacher_id= :teacherId\n" +
            "order by `day`.day_name, `lesson`.lesson_name")
    List<TimeTableView> getAllByIdTeacher(String teacherId);

    /**
     * Create by : NamHH
     * Date created: 27/02/2023
     * Function: get all timetable where id_clazz
     *
     * @Param idClazz
     */

    @Query(value = "select time_table.time_table_id as timetableId,\n" +
            "       c.clazz_id               as clazzId,\n" +
            "       c.clazz_name             as clazzName,\n" +
            "       s.subject_id             as subjectId,\n" +
            "       s.subject_name           as subjectName\n" +
            "from time_table\n" +
            "         join clazz c on c.clazz_id = time_table.clazz_id\n" +
            "         join subject s on s.subject_id = time_table.subject_id\n" +
            "where time_table.clazz_id = :idClazz",
            countQuery = "select time_table.time_table_id as timetableId,\n" +
                    "       c.clazz_id               as clazzId,\n" +
                    "       c.clazz_name             as clazzName,\n" +
                    "       s.subject_id             as subjectId,\n" +
                    "       s.subject_name           as subjectName\n" +
                    "from time_table\n" +
                    "         join clazz c on c.clazz_id = time_table.clazz_id\n" +
                    "         join subject s on s.subject_id = time_table.subject_id\n" +
                    "where time_table.clazz_id = :idClazz", nativeQuery = true)
    List<ITimetable> getAllTimetable(@Param("idClazz") Long idClazz);


    /**
     * Create by : NamHH
     * Date created: 27/02/2023
     * Function: update timetable where id_timetable
     */
    @Modifying
    @Transactional
    @Query(value = "update time_table tt set tt.subject_id = :idSubject where time_table_id=:idTimetable", nativeQuery = true)
    void updateTimetable(Long idTimetable, Long idSubject);
}
