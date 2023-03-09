package com.c0822g1primaryschoolbe.service.point;

import com.c0822g1primaryschoolbe.dto.point.PointManagementDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPointManagementService {

    /**
     * Created by: MinhCDK
     * Date created: 28/02/2023
     * Function: showListPoint
     *
     * @Param: teacherID
     */

//    List<PointManagementDto> showListPoint(Long teacherId);

    /**
     * Created by: MinhCDK
     * Date created: 22/03/2023
     * Function: editListPoint
     *
     * @Param: teacherID
     */

    void editPoint(Double semesterOne, Double semesterTwo, Long id);

    /**
     * Created by: MinhCDK
     * Date created: 28/02/2023
     * Function: searchStudentName
     *
     * @Param: teacherID
     */

    List<PointManagementDto> findByStudentName(Long teacherId, String studentName);

    void checkBoxUpClazz( Long idPoint);
}
