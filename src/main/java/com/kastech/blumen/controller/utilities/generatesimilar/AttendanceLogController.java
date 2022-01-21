package com.kastech.blumen.controller.utilities.generatesimilar;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.model.utilities.generatesimilar.AttendanceLog;
import com.kastech.blumen.repository.utilities.generatesimilar.AttendanceLogRepository;
import com.kastech.blumen.service.utilities.addto.generatesimilar.AttendanceLogServiceV1;
import com.kastech.blumen.validator.utilities.generatesimilar.AttendanceLogValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    AttendanceLogServiceV1 attendanceLogServiceV1;

    @Autowired
    AttendanceLogValidator attendanceLogValidator;
    @ResponseBody
    
    @GetMapping(path = "/attendance/log/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AttendanceLog> getAttendanceLogList() {
       return attendanceLogServiceV1.findAll();
    }


    @ResponseBody
    @PostMapping(path = "/attendance/log/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public AttendanceLog createAttendanceLog(@RequestBody AttendanceLog attendanceLog) {
        return attendanceLogServiceV1.save(attendanceLog);
    }
    
    @ResponseBody
    @PutMapping(path = "/attendance/log/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public AttendanceLog updateAttendanceLog(@RequestBody AttendanceLog attendanceLog) {
        return attendanceLogServiceV1.save(attendanceLog);
    }
    
    @ResponseBody
    @DeleteMapping(path = "/attendance/log/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteAttendanceLog(@RequestBody Long id) {
        attendanceLogServiceV1.deleteById(id);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }
}
