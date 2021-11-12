package com.kastech.blumen.controller.tutor;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.tutor.Tutor;
import com.kastech.blumen.repository.tutor.TutorRepository;
import com.kastech.blumen.service.tutor.TutorServiceV1;
import com.kastech.blumen.validator.tutor.TutorValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/blumen-api/tutor")
public class TutorController {


    private static final Logger LOGGER = LoggerFactory.getLogger(TutorController.class);

    TutorRepository tutorRepository;

    @Autowired
    TutorServiceV1 tutorServiceV1;


    @Autowired
    TutorValidator tutorValidator;

    Map<String, Tutor> tutorMap = new HashMap<String, Tutor>();

    @ResponseBody
    @GetMapping(path = "/getTutorList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Tutor>> getTutorList() {

        return ResponseEntity.ok(tutorMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/tutorList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToTutorList(@RequestBody String reqBody) {
        Tutor tutor = tutorServiceV1.doService(reqBody);
        tutorMap.put(tutor.getStaffId(),tutor);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateTutorList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editTutorList(@RequestBody String reqBody) {
        Tutor tutor = tutorServiceV1.doService(reqBody);
        tutorMap.put(tutor.getStaffId(),tutor);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/tutorlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterTutorList(@RequestBody String reqBody) {
        Tutor tutor = tutorServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteTutorList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Tutor>> deleteTutorList(@RequestBody String reqBody) {

        Tutor tutor = tutorServiceV1.doService(reqBody);
        tutorMap.remove(tutor.getStaffId());

        return ResponseEntity.status(HttpStatus.OK).body(tutorMap.values());
    }
}
