package com.kastech.blumen.controller.admin;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.repository.admin.LoggedUserRepository;
import com.kastech.blumen.service.admin.LoggedUserServiceV1;
import com.kastech.blumen.utility.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        List<LoggedUser> loggedUsers = loggedUserRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        loggedUsers = loggedUsers.stream().filter(l -> l.getExpiryDate() != null && l.getIssueDate().after(l.getExpiryDate())).collect(Collectors.toList());
        return ResponseEntity.ok(loggedUsers);
    }

    @ResponseBody
    @GetMapping(path = "/getCurrentUser/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<LoggedUser> getCurrentUser() {
        LoggedUser loggedUser = loggedUserRepository.findById(SecurityUtil.getUserId()).get();
        return ResponseEntity.ok(loggedUser);
    }

    //TODO  logged users can't be added. They were added as they login
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

    //TODO  logged users can't be deleted but can update expire customer
    @ResponseBody
    @DeleteMapping(path = "/deleteLoggedUser/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteStaffList(@RequestBody LoggedUser loggedUser) {

        loggedUserServiceV1.forceLoggedOutUser(loggedUser.getId());
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }
}
