package com.kastech.blumen.controller.counselor;

import com.kastech.blumen.model.counselor.Counselor;
import com.google.gson.Gson;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.repository.counselor.CounselorRepository;
import com.kastech.blumen.service.counselor.CounselorServiceV1;
import com.kastech.blumen.validator.counselor.CounselorValidator;
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
@RequestMapping("/api/blumen-api/counselor")
public class CounselorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CounselorController.class);

    @Autowired
    CounselorRepository counselorRepository;

    @Autowired
    CounselorServiceV1 counselorServiceV1;


    @Autowired
    CounselorValidator counselorValidator;

    Map<String, Counselor> counselorMap = new HashMap<String, Counselor>();

    @ResponseBody
    @GetMapping(path = "/getCounselorList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Counselor>> getCounselorList() {

        return ResponseEntity.ok(counselorRepository.findAll());
    }

    @ResponseBody
    @PostMapping(path = "/counselorList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToCounselorList(@RequestBody String reqBody) {
        Counselor counselor = counselorServiceV1.doService(reqBody);
        counselor = counselorRepository.save(counselor);
		if (counselor != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateCounselorList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editCounselorList(@RequestBody String reqBody) {
        Counselor counselor = counselorServiceV1.doService(reqBody);
        counselor = counselorRepository.save(counselor);
		if (counselor != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/counselorlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterCounselorList(@RequestBody String reqBody) {
        Counselor counselor = counselorServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(counselorRepository.findById(counselor.getId())));
    }


    @ResponseBody
    @PutMapping(path = "/deleteCounselorList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Counselor>> deleteCounselorList(@RequestBody String reqBody) {

        Counselor counselor = counselorServiceV1.doService(reqBody);
        counselorRepository.delete(counselor);

        return ResponseEntity.status(HttpStatus.OK).body(counselorMap.values());
    }


}
