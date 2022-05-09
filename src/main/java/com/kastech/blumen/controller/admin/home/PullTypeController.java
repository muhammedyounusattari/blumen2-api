package com.kastech.blumen.controller.admin.home;

import com.kastech.blumen.model.admin.home.PullType;
import com.kastech.blumen.model.admin.home.PullTypeMultiSearchRequest;
import com.kastech.blumen.model.admin.home.PullTypeSearchRequest;
import com.kastech.blumen.service.home.PullTypeServiceV1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/blumen-api/admin/home")
public class PullTypeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PullTypeController.class);
    @Autowired
    private PullTypeServiceV1 pullTypeServiceV1;

    @ResponseBody
    @GetMapping (path = "/getPullTypesList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PullType>> getPullTypesList(@RequestParam(value = "pullType",required = false) String pullType,@RequestParam(value = "description",required = false) String
            description,@RequestParam(value = "programType",required = false) Long programType) {
        PullTypeSearchRequest pullTypeSearchRequest = new PullTypeSearchRequest();
        pullTypeSearchRequest.setPullType(pullType);
        pullTypeSearchRequest.setDescription(description);
        pullTypeSearchRequest.setProgramType(programType);
        return new ResponseEntity<>(pullTypeServiceV1.findPullTypesList(pullTypeSearchRequest),HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping (path = "/getMultiPullTypesList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String,List<PullType>>> getMultiPullTypesList(@RequestParam(value = "pullType",required = true) String pullType
      , @RequestParam(value = "programType",required = false) Long programType) {
        PullTypeMultiSearchRequest pullTypeSearchRequest = new PullTypeMultiSearchRequest();
        pullTypeSearchRequest.setPullType(pullType);
        pullTypeSearchRequest.setProgramType(programType);
        return new ResponseEntity<>(pullTypeServiceV1.findPullTypesList(pullTypeSearchRequest),HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping (path = "/updatePullType/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PullType> updatePullType(@RequestBody PullType pullType) {
        pullTypeServiceV1.updatePullType(pullType);
        return new ResponseEntity<>(pullType, HttpStatus.OK);
    }


    @RequestMapping (path = "/downloadPullType/v1",method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadPullType(@RequestParam(value = "pullType",required = false) String pullType, @RequestParam(value = "description",required = false) String
            description, @RequestParam(value = "programType",required = false) Long programType,
                                                     HttpServletResponse response) {
        PullTypeSearchRequest pullTypeSearchRequest = new PullTypeSearchRequest();
        pullTypeSearchRequest.setPullType(pullType);
        pullTypeSearchRequest.setDescription(description);
        pullTypeSearchRequest.setProgramType(programType);
        InputStreamResource iis =null;

        try {
            // get your file as InputStream
             iis = new InputStreamResource(new ByteArrayInputStream(pullTypeServiceV1.downloadPullType(pullTypeSearchRequest).toByteArray()));

        } catch (IOException ex) {
            LOGGER.error(ex.toString(),ex);
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,String.format("attachment; filename=PullType.xlsx"))
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(iis);

    }


    @ResponseBody
    @GetMapping (path = "/getPullTypesListByOrgId/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PullType>> getPullTypesListByOrgId(@RequestParam(value = "pullType",required = false) Long orgId) {

        return new ResponseEntity<>(pullTypeServiceV1.findPullTypesList(orgId),HttpStatus.OK);
    }
}
