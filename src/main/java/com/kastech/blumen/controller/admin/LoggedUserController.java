package com.kastech.blumen.controller.admin;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.repository.admin.LoggedUserRepository;
import com.kastech.blumen.service.admin.LoggedUserServiceV1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/blumen-api/logged-user")
public class LoggedUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggedUserController.class);

    @Autowired
    LoggedUserRepository loggedUserRepository;

    @Autowired
    LoggedUserServiceV1 loggedUserServiceV1;


    @ResponseBody
    @GetMapping(path = "/getLoggedUsers/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<LoggedUser>> getLoggedUsers() {

        return ResponseEntity.ok(loggedUserRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }

    @ResponseBody
    @PostMapping(path = "/addLoggedUser/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStaffList(@RequestBody LoggedUser loggedUser) {
        loggedUser = loggedUserRepository.save(loggedUser);
		if (loggedUser != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping(path = "/deleteLoggedUser/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteStaffList(@RequestBody LoggedUser loggedUser) {

        loggedUserRepository.delete(loggedUser);

        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }
}
