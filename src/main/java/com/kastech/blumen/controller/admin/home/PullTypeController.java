package com.kastech.blumen.controller.admin.home;

import com.kastech.blumen.model.admin.home.PullType;
import com.kastech.blumen.model.admin.home.PullTypeSearchRequest;
import com.kastech.blumen.service.home.PullTypeServiceV1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
    @PutMapping (path = "/updatePullType/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PullType> updatePullType(@RequestBody PullType pullType) {
        pullTypeServiceV1.updatePullType(pullType);
        return new ResponseEntity<>(pullType, HttpStatus.OK);
    }


    @RequestMapping (path = "/downloadPullType/v1",method = RequestMethod.GET)
    public void downloadPullType(@RequestParam(value = "pullType",required = false) String pullType,@RequestParam(value = "description",required = false) String
            description,@RequestParam(value = "programType",required = false) Long programType,
                                                           HttpServletResponse response) {
        PullTypeSearchRequest pullTypeSearchRequest = new PullTypeSearchRequest();
        pullTypeSearchRequest.setPullType(pullType);
        pullTypeSearchRequest.setDescription(description);
        pullTypeSearchRequest.setProgramType(programType);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", String.format("inline; filename=\"PullType.xlsx\""));

        try {
            // get your file as InputStream
            InputStream iis = new ByteArrayInputStream(pullTypeServiceV1.downloadPullType(pullTypeSearchRequest).toByteArray());

            // copy it to response's OutputStream
            org.apache.commons.io.IOUtils.copy(iis, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            LOGGER.error(ex.toString(),ex);
        }

    }
}
