package com.kastech.blumen.controller.tutor;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.tutor.Tutor;
import com.kastech.blumen.repository.tutor.TutorRepository;
import com.kastech.blumen.service.tutor.TutorServiceV1;
import com.kastech.blumen.validator.tutor.TutorValidator;

@RestController
@RequestMapping("/api/blumen-api/tutor")
public class TutorController {


    private static final Logger LOGGER = LoggerFactory.getLogger(TutorController.class);

    @Autowired
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

    	List<Tutor> tutorList=  tutorRepository.findAll();
    	
        return ResponseEntity.ok(tutorList);
    }

	@ResponseBody
	@PostMapping(path = "/tutorList/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addToTutorList(@RequestBody Tutor tutor) {
		tutor = tutorRepository.save(tutor);
		if (tutor != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
		else
			return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

    @ResponseBody
    @PutMapping(path = "/updateTutorList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editTutorList(@RequestBody Tutor tutor) {
        tutor = tutorRepository.save(tutor);
        if (tutor != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
		else
			return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/tutorlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterTutorList(@RequestBody String reqBody) {
        Tutor tutor = tutorServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body(tutorRepository.findAll().toString());
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteTutorList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Tutor>> deleteTutorList(@RequestBody Tutor tutor) {

        Optional<Tutor> tutorDb = tutorRepository.findById(tutor.getId());
    	
		if(tutorDb!=null && tutorDb.isPresent()) {
			tutorRepository.delete(tutorDb.get()); 
			return new ResponseEntity(new Response(200, "Successfully deleted tutor with id : " + tutor.getId() ), null, HttpStatus.OK);
		}

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
    }
}
