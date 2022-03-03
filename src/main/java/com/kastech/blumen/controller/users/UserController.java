package com.kastech.blumen.controller.users;

import com.kastech.blumen.controller.student.StudentController;
import com.kastech.blumen.model.Configurations.GenerateResponse;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.StudentDataObject;
import com.kastech.blumen.model.users.Priviledges;
import com.kastech.blumen.service.users.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/student")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServices userServices;

    @ResponseBody
    @GetMapping(path = "/getPriviledgeLists/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Priviledges>> getPriviledgeLists() {
        return ResponseEntity.accepted().body(userServices.getPriviledgeLists());
    }

    @ResponseBody
    @PostMapping(path = "/getPriviledgeListByRoleId/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public GenerateResponse getPriviledgeListByRoleId(@RequestBody Long roleId) {
        return userServices.getPriviledgeListByRoleId(roleId);
    }
}
