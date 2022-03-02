package com.kastech.blumen.controller.utilities.addto;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.StudentYearlyData;
import com.kastech.blumen.model.utilities.FiscalGraduatedYearRequest;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.utilities.addto.FiscalYearRepository;
import com.kastech.blumen.service.utilities.addto.FiscalYearServiceV1;
import com.kastech.blumen.validator.utilities.addto.FiscalYearValidator;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/blumen-api/utilities/addto")
public class FiscalYearController {


    private static final Logger LOGGER = LoggerFactory.getLogger(FiscalYearController.class);

    FiscalYearRepository fiscalYearRepository;

    @Autowired
    FiscalYearServiceV1 fiscalYearServiceV1;

    @Autowired
    StudentRepository studentRepository;


    @Autowired
    FiscalYearValidator fiscalYearValidator;


   /* @ResponseBody
    @GetMapping(path = "/getAllStudentsByFiscalYear/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> getAllStudentsByFiscalYear(@RequestParam("fiscalYear") String fiscalYear) {
        List<Student> studentList = studentRepository.findAllStudentbyFiscalYear(fiscalYear);

        return ResponseEntity.ok(studentList);
    }
*/

    @ResponseBody
    @PostMapping(path = "/moveSelectedStudentListToFiscalYear/v1",consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> moveSelectedStudentListToFiscalYear(@RequestBody FiscalGraduatedYearRequest fiscalYearRequest) {
        List<String> ssnoList = null;
        String fiscalYear = null;
        /*if (null != fiscalYearRequest) {
            fiscalYear = fiscalYearRequest.getFiscalYear();
            ssnoList = fiscalYearRequest.getSsnoList();
            LOGGER.info("Students to be moved to fiscal year " + fiscalYearRequest.getFiscalYear());
            LOGGER.info("no of received students received to move to fiscal year " + ssnoList.size());
            List<Student> studentsListObj = new ArrayList<>();
            if (!ssnoList.isEmpty()) {

                for (String ssno : ssnoList) {
                    Optional<Student> studentObj = studentRepository.findById(Long.parseLong(ssno));
                    StudentYearlyData studentYearlyData = studentObj.getStudentYearlyData();
                    studentYearlyData.setYearfi(8);
                    studentObj.get().setStudentYearlyData(studentYearlyData);
                    studentsListObj.add(studentObj.get());
                }
            }
            studentRepository.saveAll(studentsListObj);
        }
*/
        return new ResponseEntity(new Response(200, ssnoList.size() + " no of Students are added to the fiscal year " + fiscalYear), null, HttpStatus.OK);
    }


}

