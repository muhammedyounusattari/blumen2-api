package com.kastech.blumen.controller.staff;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.staff.Staff;
import com.kastech.blumen.repository.staff.StaffRepository;
import com.kastech.blumen.service.staff.StaffServiceV1;
import com.kastech.blumen.validator.staff.StaffValidator;
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
@RequestMapping("/api/blumen-api/staff")
public class StaffController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);

    StaffRepository staffRepository;

    @Autowired
    StaffServiceV1 staffServiceV1;


    @Autowired
    StaffValidator staffValidator;

    Map<String, Staff> staffMap = new HashMap<String, Staff>();

    @ResponseBody
    @GetMapping(path = "/getStaffList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Staff>> getStaffList() {

        return ResponseEntity.ok(staffMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/staffList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStaffList(@RequestBody String reqBody) {
        Staff staff = staffServiceV1.doService(reqBody);
        staffMap.put(staff.getStaffId(),staff);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStaffList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStaffList(@RequestBody String reqBody) {
        Staff staff = staffServiceV1.doService(reqBody);
        staffMap.put(staff.getStaffId(),staff);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/stafflist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStaffList(@RequestBody String reqBody) {
        Staff staff = staffServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStaffList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Staff>> deleteStaffList(@RequestBody String reqBody) {

        Staff staff = staffServiceV1.doService(reqBody);
        staffMap.remove(staff.getStaffId());

        return ResponseEntity.status(HttpStatus.OK).body(staffMap.values());
    }
}
