package com.kastech.blumen.service.student.logs;

import com.kastech.blumen.model.student.logs.StudentNotesLog;
import com.kastech.blumen.repository.student.logs.StudentNotesLogRepository;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentNotesLogServiceV1 {

    @Autowired
    StudentNotesLogRepository studentNotesLogRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentNotesLogServiceV1.class);

    public StudentNotesLog doService(String reqBody){

        StudentNotesLog studentNotesLog = CommonUtil.convertJsonStringToPojoForStudentNotesLog(reqBody);

        return studentNotesLog;
    }

    public StudentNotesLog addStudentNotesLog(StudentNotesLog studentNotesLog) {
        return studentNotesLogRepository.save(studentNotesLog);
    }

    public Optional<StudentNotesLog> editStudentNotesLogList(StudentNotesLog studentNotesLog) {
        return studentNotesLogRepository.findById(studentNotesLog.getSsno())
                .map(oldItem -> {
                    StudentNotesLog updated = oldItem.updateWith(studentNotesLog);
                    return studentNotesLogRepository.save(updated);
                });
    }
}
