package com.kastech.blumen.service.utilities.addto.generatesimilar;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.utilities.generatesimilar.AttendanceLog;
import com.kastech.blumen.repository.utilities.generatesimilar.AttendanceLogRepository;

@Service
public class AttendanceLogServiceV1 {
	
	@Autowired
	AttendanceLogRepository attendanceLogRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceLogServiceV1.class);

	public List<AttendanceLog> findAll() {
		return attendanceLogRepository.findAll();
	}

	public AttendanceLog save(AttendanceLog attendanceLog) {
		return attendanceLogRepository.save(attendanceLog);
	}

	public void deleteById(Long id) {
		attendanceLogRepository.deleteById(id);
	}
}
