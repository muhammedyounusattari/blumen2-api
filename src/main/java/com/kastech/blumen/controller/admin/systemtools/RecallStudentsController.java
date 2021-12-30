package com.kastech.blumen.controller.admin.systemtools;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.admin.systemtools.RecallStudentsRepository;
import com.kastech.blumen.service.admin.systemtools.RecallStudentsServiceV1;
import com.kastech.blumen.validator.admin.systemtools.RecallStudentsValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/admin/systemtools")
public class RecallStudentsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RecallStudentsController.class);

	@Autowired
	RecallStudentsRepository recallStudentsRepository;

	@Autowired
	RecallStudentsServiceV1 recallStudentsServiceV1;

	@Autowired
	RecallStudentsValidator recallStudentsValidator;

	@ResponseBody
	@GetMapping(path = "/recallStudentList/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Student>> recallStudentList() {
		return ResponseEntity.status(HttpStatus.OK).body(recallStudentsRepository.findAll(Sort.by(Sort.Direction.ASC, "ssno")));
	}
}
