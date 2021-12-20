package com.kastech.blumen.service.student.logs;

import com.kastech.blumen.model.student.logs.StudentAttendanceLog;
import com.kastech.blumen.repository.student.logs.StudentAttendanceLogRepository;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentAttendanceLogServiceV1 {

    @Autowired
    StudentAttendanceLogRepository studentAttendanceLogRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentAttendanceLogServiceV1.class);

    public StudentAttendanceLog doService(String reqBody) {

        StudentAttendanceLog studentAttendanceLog = CommonUtil.convertJsonStringToPojoForStudentAttendanceLog(reqBody);


        return studentAttendanceLog;

    }

    public StudentAttendanceLog addStudentAttendanceLogList(StudentAttendanceLog studentAttendanceLog) {
        return studentAttendanceLogRepository.save(studentAttendanceLog);
    }

    public Optional<StudentAttendanceLog> editStudentAttendanceLogList(StudentAttendanceLog studentAttendanceLog) {
        return studentAttendanceLogRepository.findById(studentAttendanceLog.getSsno())
                .map(oldItem -> {
                    StudentAttendanceLog updated = oldItem.updateWith(studentAttendanceLog);
                    return studentAttendanceLogRepository.save(updated);
                });
    }
}

/*ObjectMapper mapper = new ObjectMapper();

        StudentAttendanceLog staff   = null;
        try {
            staff = mapper.readValue(CommonUtil.convertJsonStringToPojo1(reqBody), StudentAttendanceLog.class);
        } catch (IOException e) {
            e.printStackTrace();
        }*/