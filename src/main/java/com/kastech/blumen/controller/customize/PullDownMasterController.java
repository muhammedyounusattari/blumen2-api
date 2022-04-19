package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.customize.PullDownMaster;
import com.kastech.blumen.model.customize.PullDownMasterCreateRequest;
import com.kastech.blumen.service.customize.PullDownMasterServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/customize")
public class PullDownMasterController {

    @Autowired
    private PullDownMasterServiceV1 pullDownMasterServiceV1;

    @ResponseBody
    @GetMapping(path = "/getPullDownMaster/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PullDownMaster> getPullDownList(@RequestParam(required = true) Long orgId,@RequestParam(required = false) Long projType,
                                                @RequestParam(required = true) String pullType) {
        return pullDownMasterServiceV1.getPullDownList(orgId , pullType,projType);
    }

    @ResponseBody
    @PostMapping(path = "/savePullDownMaster/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PullDownMaster savePullDownMaster(@RequestBody @Valid PullDownMasterCreateRequest pullDownMasterCreateRequest) {
        return pullDownMasterServiceV1.savePullDownMaster(pullDownMasterCreateRequest);
    }

    @ResponseBody
    @PutMapping(path = "/updatePullDownMaster/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PullDownMaster updatePullDownList(@RequestBody  PullDownMaster pullDownMaster) {
        return pullDownMasterServiceV1.updatePullDownMaster(pullDownMaster);
    }


    @ResponseBody
    @DeleteMapping(path = "/deletePullDownMaster/v1")
    public ResponseEntity<String> deletePullDownMaster(@RequestBody  PullDownMaster pullDownMaster) {
        pullDownMasterServiceV1.deletePullDownMaster(pullDownMaster);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
}
