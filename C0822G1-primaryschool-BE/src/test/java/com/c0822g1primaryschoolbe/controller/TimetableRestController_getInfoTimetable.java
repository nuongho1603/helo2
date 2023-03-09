package com.c0822g1primaryschoolbe.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TimetableRestController_getInfoTimetable {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getInfoTimetable_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/listTimetable/{idClazz}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    @Test
    public void getInfoTimetable_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/listTimetable/{idClazz}", "100"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }



    @Test
    public void getInfoTimetable_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/listTimetable/{idClazz}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(jsonPath("$[0].timeSubId").value(1),
                        jsonPath("$[0].subId").value(2),
                        jsonPath("$[0].nameClazz").value("1A"),
                        jsonPath("$[0].nameLesson").value("Tiết 1"),
                        jsonPath("$[0].nameDay").value("Thứ 2"),
                        jsonPath("$[0].nameSubject").value("Anh"));
    }

    ////    @Test
//    public void updateTimetableSubject_list_19() throws Exception {
//        List<TimeTableSubject> timeTableSubjectList = new ArrayList<>();
//        TimeTableSubject timeTableSubject = new TimeTableSubject();
//
//        Subject subject = new Subject();
//        subject.setSubjectId(null);
//        subject.setSubjectId(1L);
//        timeTableSubject.setSubject(subject);
//
//        TimeTable timeTable = new TimeTable();
//        timeTable.setTimeTableId(1L);
//        timeTable.setTimeTableId(2L);
//        timeTableSubject.setTimeTable(timeTable);
//
//        timeTableSubject.setId(1L);
//        timeTableSubject.setId(2L);
//        timeTableSubjectList.add(timeTableSubject);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/updateTimetableSubject")
//                        .content(this.objectMapper.writeValueAsString(timeTableSubjectList))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
////    @Test
//    public void updateTimetableSubject_list_24() throws Exception {
//        List<TimeTableSubject> timeTableSubjectList = new ArrayList<>();
//        TimeTableSubject timeTableSubject = new TimeTableSubject();
//
//        Subject subject = new Subject();
//        subject.setSubjectId(1L);
//        subject.setSubjectId(1L);
//        timeTableSubject.setSubject(subject);
//
//        TimeTable timeTable = new TimeTable();
//        timeTable.setTimeTableId(1L);
//        timeTable.setTimeTableId(2L);
//        timeTableSubject.setTimeTable(timeTable);
//
//        timeTableSubject.setId(1L);
//        timeTableSubject.setId(2L);
//        timeTableSubjectList.add(timeTableSubject);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/updateTimetableSubject")
//                        .content(this.objectMapper.writeValueAsString(timeTableSubjectList))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
}
