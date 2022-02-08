package com.kastech.blumen.controller.staff;

import com.google.gson.Gson;
import com.kastech.blumen.constants.RestURIConstant;
import com.kastech.blumen.model.Address;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.staff.Staff;
import com.kastech.blumen.repository.staff.StaffRepository;
import com.kastech.blumen.service.staff.StaffServiceV1;
import com.kastech.blumen.validator.staff.StaffValidator;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/blumen-api/staff")
public class StaffController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    StaffServiceV1 staffServiceV1;

    @Autowired
    StaffValidator staffValidator;

    @ResponseBody
    @GetMapping(path = "/getStaffList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Staff>> getStaffList() {
        return ResponseEntity.ok(staffServiceV1.validatePhoneNumber());
    }

    @ResponseBody
    @PostMapping(path = "/staffList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStaffList(@RequestBody Staff staff) {
        staff = staffRepository.save(staff);
        if (staff != null)
            return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

        return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStaffList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStaffList(@RequestBody Staff staff) {
        staff = staffRepository.save(staff);
        if (staff != null)
            return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

        return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/stafflist/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> filterStaffList(@RequestBody Staff staff) {
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(staffRepository.findById(staff.getId())));
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteStaffList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteStaffList(@RequestBody Staff staff) {

        staffRepository.delete(staff);

        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }

    @PostMapping(value = RestURIConstant.FILE_UPLOAD, consumes = "multipart/form-data")
    public ResponseEntity<?> uploadFileMulti(@PathVariable(name = "staffId", required = true) Long staffId,
                                             @RequestParam("uploadfile") MultipartFile file) {


        if(file.isEmpty()){
            LOGGER.error("file tried to upload is empty {}", file);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Map<String, Long> resultMap = new HashMap<>();
        try {
            //TODO - replace system upload with
            staffId = staffServiceV1.uplaodFile(file,staffId);
            resultMap.put("staffId", staffId);
        } catch ( IOException e) {
            return  new ResponseEntity<>(new Response(500, "failure"), null, HttpStatus.BAD_REQUEST);
        } catch(Exception e){
            return  new ResponseEntity<>(new Response(500, "failure"), null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(staffId, HttpStatus.OK);
    }


    @RequestMapping(value = RestURIConstant.FILE_UPLOAD, method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("staffId") String staffId) throws IOException {

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(staffServiceV1.getFile(staffId));
    }
}
