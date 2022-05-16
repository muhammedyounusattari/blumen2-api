package com.kastech.blumen.controller.student.dataentry;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.dataentry.GraduatedRepository;
import com.kastech.blumen.service.student.dataentry.GraduatedServiceV1;
import com.kastech.blumen.validator.student.dataentry.GraduatedValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/student-dataentry")
public class GraduatedController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraduatedController.class);

    @Autowired
    GraduatedRepository graduatedRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    GraduatedServiceV1 graduatedServiceV1;


    @Autowired
    GraduatedValidator graduatedValidator;


    List<Student> studentList = new ArrayList<>();

    Map<Long, GraduatedInformation> graduatedInformationMap = new HashMap<>();

    Map<Long, Student> studentMap = new HashMap<Long, Student>();

    @ResponseBody
    @PostMapping(path = "/saveGraduatedInfoForStudent/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Student saveGraduatedInfoForStudent(@RequestBody GraduatedInformation graduatedInformation, @RequestParam("student-ssno") String studentSsno) {

        Optional<Student> student = studentRepository.findById(Long.parseLong(studentSsno));
        Student studentData = student.get();
//        studentData.setGraduatedInformation(graduatedInformation);
        return studentRepository.save(studentData);

    }


    @ResponseBody
    @PostMapping(path = "/saveAddressNotesForStudent/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<GraduatedInformation> saveAddressNotesForStudent(@RequestBody AddressNotes addressNotes, @RequestParam("student-ssno") String studentSsno) {

        Optional<Student> student = studentRepository.findById(Long.parseLong(studentSsno));
//        GraduatedInformation graduatedInformation1 = student.get().getGraduatedInformation();
//        graduatedInformation1.setAddressNotes(addressNotes);
//
//        return graduatedRepository.findById(graduatedInformation1.getSsno())
//                .map(oldItem -> {
//                    GraduatedInformation updated = oldItem.updateWith(graduatedInformation1);
//                    return graduatedRepository.save(updated);
//                });
        return null;
    }

    @ResponseBody
    @PutMapping(path = "/editGraduated/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<GraduatedInformation> editGraduated(@RequestBody AddressNotes addressNotes, @RequestParam("student-ssno") String studentSsno) {
        GraduatedInformation graduatedInformation = graduatedInformationMap.get(studentSsno);
        //   AddressNotes addressNotes = graduatedServiceV1.doServiceForAddressNotes(reqBody);


       /* graduatedInformation.setAddressNotes(addressNotes);
        graduatedInformationMap.put(studentSsno, graduatedInformation);
        return ResponseEntity.ok(graduatedInformationMap.values());*/


        Optional<Student> student = studentRepository.findById(Long.parseLong(studentSsno));
//        GraduatedInformation graduatedInformation1 = student.get().getGraduatedInformation();
//        graduatedInformation1.setAddressNotes(addressNotes);
//
//        return graduatedRepository.findById(graduatedInformation1.getSsno())
//                .map(oldItem -> {
//                    GraduatedInformation updated = oldItem.updateWith(graduatedInformation);
//                    return graduatedRepository.save(updated);
//                });
        return null;
    }

    @ResponseBody
    @DeleteMapping(path = "/deleteGraduated/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteGraduated(@RequestParam("student-ssno") String studentSsno) {

        graduatedRepository.deleteById(Long.parseLong(studentSsno));
        // return ResponseEntity.noContent().build();
        return ResponseEntity.ok("Deleted Successfully");
    }


}
