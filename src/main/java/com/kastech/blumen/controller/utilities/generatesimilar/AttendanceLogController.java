package com.kastech.blumen.controller.utilities.generatesimilar;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.utilities.generatesimilar.AttendanceLog;
import com.kastech.blumen.repository.utilities.generatesimilar.AttendanceLogRepository;
import com.kastech.blumen.service.utilities.addto.generatesimilar.AttendanceLogServiceV1;
import com.kastech.blumen.validator.utilities.generatesimilar.AttendanceLogValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/utilities/generate-similar")
public class AttendanceLogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceLogController.class);

    @Autowired
    AttendanceLogRepository attendanceLogRepository;

    @Autowired
    AttendanceLogServiceV1 attendanceLogServiceV1;


    @Autowired
    AttendanceLogValidator attendanceLogValidator;

    List<Student> studentList = new ArrayList<>();


    public void addStudentProfile() {

        Student studentOne = new Student(111-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentOne);

        Student studentTwo = new Student(111-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentTwo);
        Student studentThree = new Student(111-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentThree);

        Student studentFour = new Student(111-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2018");
        studentList.add(studentFour);

        Student studentFive = new Student(111-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2018");
        studentList.add(studentFive);
    }

    @ResponseBody
    @GetMapping(path = "/getOkToContinueAttendanceLogList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AttendanceLog> getAttendanceLogList() {
        List<AttendanceLog> list = new ArrayList<>();
        Iterable<AttendanceLog> items = attendanceLogRepository.findAll();
        items.forEach(list::add);
        return list;
    }


    @ResponseBody
    @PostMapping(path = "/clickFinishAttendanceLogList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public AttendanceLog clickFinishAttendanceLogList(@RequestBody String reqBody) {
        AttendanceLog attendanceLog = attendanceLogServiceV1.doService(reqBody);
        return attendanceLogRepository.save(attendanceLog);
    }
}
