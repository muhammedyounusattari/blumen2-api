package com.kastech.blumen.controller.admin;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.keycloak.UserSecurityInfo;
import com.kastech.blumen.model.keycloak.UserSecurityInfoId;
import com.kastech.blumen.repository.admin.UserSecurityInfoRepository;
import com.kastech.blumen.service.admin.UserSecurityInfoServiceV1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/blumen-api/user-security-info")
public class UserSecurityInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserSecurityInfoController.class);

    @Autowired
    UserSecurityInfoRepository userSecurityInfoRepository;

    @Autowired
    UserSecurityInfoServiceV1 userSecurityInfoServiceV1;


    @ResponseBody
    @GetMapping(path = "/getUserSecurityInfoById/{id}/{orgId}/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional<UserSecurityInfo>> getUserSecurityInfo(@PathVariable String id, @PathVariable String orgId) {
        UserSecurityInfoId userSecurityInfoId = new UserSecurityInfoId(id, orgId);
        return ResponseEntity.ok(userSecurityInfoRepository.findById(userSecurityInfoId));
    }

    @ResponseBody
    @GetMapping(path = "/getUserSecurityInfoByUsername/{username}/{orgId}/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional<UserSecurityInfo>> getUserSecurityInfoByUsername(@PathVariable String username,
                                                                                      @PathVariable String orgId) {
        return ResponseEntity.ok(userSecurityInfoRepository.findByUsername(username, orgId));
    }

    @ResponseBody
    @PostMapping(path = "/addUserSecurityInfo/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addUserSecurityInfo(@RequestBody UserSecurityInfo userSecurityInfo) {
        userSecurityInfo = userSecurityInfoRepository.save(userSecurityInfo);
		if (userSecurityInfo != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping(path = "/deleteLoggedUser/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteSecurityInfo(@RequestBody UserSecurityInfo userSecurityInfo) {

        userSecurityInfoRepository.delete(userSecurityInfo);

        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }
}
