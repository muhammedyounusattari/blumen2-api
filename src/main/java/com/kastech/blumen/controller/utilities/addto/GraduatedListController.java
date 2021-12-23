package com.kastech.blumen.controller.utilities.addto;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.repository.utilities.addto.GraduatedListRepository;
import com.kastech.blumen.service.utilities.addto.GraduatedListServiceV1;
import com.kastech.blumen.validator.utilities.addto.GraduatedListValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/utilities/addto")
public class GraduatedListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraduatedListController.class);

    @Autowired
    GraduatedListServiceV1 graduatedListServiceV1;


    @Autowired
    GraduatedListValidator graduatedListValidator;

    @ResponseBody
    @GetMapping(path = "/getGraduatedList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> getGraduatedList() {
        return ResponseEntity.ok(graduatedListServiceV1.getGraduatedList());
    }

    @ResponseBody
    @GetMapping(path = "/moveAllStudentsByGraduatedYear/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> moveAllStudentsByGraduatedYear(@RequestParam("fiscalYear") String fiscalYear) {

		
//		for (int i = 0; i < studentList.size(); i++) {
//			studentList.get(i).setFiscalYear(fiscalYear);
//		}
		 
        return ResponseEntity.ok(graduatedListServiceV1.getGraduatedList());
    }
}
