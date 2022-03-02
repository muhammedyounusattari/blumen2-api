package com.kastech.blumen.controller.users;

import com.kastech.blumen.model.Configurations.GenerateResponse;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.StudentDataObject;
import com.kastech.blumen.model.users.Priviledges;
import com.kastech.blumen.service.users.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/student")
public class UserController {

    @Autowired
    private UserServices userServices;

    @ResponseBody
    @GetMapping(path = "/getPriviledgeLists/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public GenerateResponse getPriviledgeLists() {
        return userServices.getPriviledgeLists();
    }

    @ResponseBody
    @PostMapping(path = "/getPriviledgeListByRoleId/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public GenerateResponse getPriviledgeListByRoleId(@RequestBody Long roleId) {
        return userServices.getPriviledgeListByRoleId(roleId);
    }
}
