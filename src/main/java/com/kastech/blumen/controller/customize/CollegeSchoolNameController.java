package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.RequestDataVO;
import com.kastech.blumen.model.customize.CollegeSchool;
import com.kastech.blumen.repository.customize.CollegeSchoolRepository;
import com.kastech.blumen.service.customize.CollegeSchoolServiceV1;
import com.kastech.blumen.utility.RequestAPIType;
import com.kastech.blumen.validator.customize.CollegeSchoolValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/customize")
public class CollegeSchoolNameController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CollegeSchoolNameController.class);

    @Autowired
    CollegeSchoolRepository collegeSchoolRepository;

    @Autowired
    CollegeSchoolServiceV1 collegeSchoolServiceV1;


    @Autowired
    CollegeSchoolValidator collegeShoolValidator;

    Map<String, CollegeSchool> schoolCollegeMap = new HashMap<String, CollegeSchool>();

    @ResponseBody
    @GetMapping(path = "/getCollegeSchoolNameList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CollegeSchool> getCollegeSchoolNameList() {

        List<CollegeSchool> list = new ArrayList<>();
        Iterable<CollegeSchool> items = collegeSchoolRepository.findAll();
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/collegeSchoolNameList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CollegeSchool addToCollegeSchoolNameList(@RequestBody CollegeSchool collegeSchool) {
      //  CollegeSchool collegeSchool = collegeSchoolServiceV1.doService(reqBody);
        return collegeSchoolRepository.save(collegeSchool);
    }

    @ResponseBody
    @PutMapping(path = "/updateCollegeSchoolNameList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<CollegeSchool> editCollegeSchoolNameList(@RequestBody CollegeSchool collegeSchool) {
     //   CollegeSchool collegeSchool = collegeSchoolServiceV1.doService(reqBody);

        return collegeSchoolRepository.findById(collegeSchool.getOrgName())
                .map(oldItem -> {
                    CollegeSchool updated = oldItem.updateWith(collegeSchool);
                    return collegeSchoolRepository.save(updated);
                });
    }


    @ResponseBody
    @PutMapping(path = "/filter/collegeSchoolNamelist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterPullDownList(@RequestBody CollegeSchool collegeSchool) {
      //  CollegeSchool pullDown = collegeSchoolServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteCollegeSchoolNameList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteCollegeSchoolNameList(@RequestBody CollegeSchool collegeSchool) {

      //  CollegeSchool collegeSchool = collegeSchoolServiceV1.doService(reqBody);
        collegeSchoolRepository.delete(collegeSchool);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }


    @ResponseBody
    @GetMapping(path = "/collegeSchoolName/search/v1/{name}/{value}",
            produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CollegeSchool>> searchCollegeSchoolNameList(@PathVariable Map<String, String> pathVars, @RequestBody String reqBody) {
        RequestDataVO requestDataVO = collegeShoolValidator.validate(RequestAPIType.PULL_DOWN_LIST_V1, reqBody,pathVars);
        String name = requestDataVO.getInputPathVars().get("name");
        String value = requestDataVO.getInputPathVars().get("value");
        List<CollegeSchool> list = new ArrayList<>();
        if(null!=schoolCollegeMap.get(value)){
            list.add(schoolCollegeMap.get(value));
            CollegeSchool pullDown = collegeSchoolServiceV1.doService(requestDataVO.getInputReqBodyString());
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
