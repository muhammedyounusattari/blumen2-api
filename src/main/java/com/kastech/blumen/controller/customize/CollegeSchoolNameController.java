package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.RequestDataVO;
import com.kastech.blumen.model.Response;
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

    /**
     * Inject the collegeSchoolRepository
     */
    @Autowired
    CollegeSchoolRepository collegeSchoolRepository;

    /**
     * Inject the collegeSchoolServiceV1
     */
    @Autowired
    CollegeSchoolServiceV1 collegeSchoolServiceV1;

    /**
     * Inject the collegeShoolValidator
     */
    @Autowired
    CollegeSchoolValidator collegeShoolValidator;

    Map<String, CollegeSchool> schoolCollegeMap = new HashMap<String, CollegeSchool>();

    /**
     * Get the all college school list
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getCollegeSchoolNameList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CollegeSchool> getCollegeSchoolNameList() {
        List<CollegeSchool> list = new ArrayList<>();
        //session param
        long sessionOrgId = 1;
        Iterable<CollegeSchool> items = collegeSchoolRepository.findByOrgId(sessionOrgId);
        items.forEach(list::add);
        return list;

    }

    /**
     * Add the college record
     * @param collegeSchool
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/addCollegeNameList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CollegeSchool addToCollegeNameList(@RequestBody CollegeSchool collegeSchool) {
        //session param
        long sessionOrgId = 1;
        String fafsaId = collegeSchool.getFafsaId();
        if (null != fafsaId && !fafsaId.isEmpty()) {
            collegeSchool.setNcesId(null);
        }

        collegeSchool.setOrgId(sessionOrgId);
        collegeSchool.setCreatedDate(new Date());
        CollegeSchool collegeSchoolList = collegeSchoolRepository.save(collegeSchool);
        //session param
        long collegeSchoolId = collegeSchoolList.getCollegeSchoolId();
        collegeSchoolList.setCreatedBy(collegeSchoolId);
        return collegeSchoolRepository.save(collegeSchoolList);
    }

    /**
     * Add the school record
     * @param collegeSchool
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/addSchoolNameList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CollegeSchool addToSchoolNameList(@RequestBody CollegeSchool collegeSchool) {

        //session param
        long sessionOrgId = 1;
        String ncesId = collegeSchool.getNcesId();
        if (null != ncesId && !ncesId.isEmpty()) {
            collegeSchool.setFafsaId(null);
        }

        collegeSchool.setOrgId(sessionOrgId);
        collegeSchool.setCreatedDate(new Date());
        CollegeSchool collegeSchoolList = collegeSchoolRepository.save(collegeSchool);
        //session param
        long collegeSchoolId = collegeSchoolList.getCollegeSchoolId();
        collegeSchoolList.setCreatedBy(collegeSchoolId);
        return collegeSchoolRepository.save(collegeSchoolList);


    }

    /**
     * Update the college school name by id.
     * @param collegeSchool
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/updateCollegeSchoolNameList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CollegeSchool editCollegeSchoolNameList(@RequestBody CollegeSchool collegeSchool) {
        long sessionOrgId = 1;
        CollegeSchool item = collegeSchoolRepository.findByCollegeSchoolIdAndOrgId(collegeSchool.getCollegeSchoolId(), sessionOrgId);

        collegeSchool.setModifiedDate(new Date());
        collegeSchool.setModifiedBy(item.getCollegeSchoolId());
        collegeSchool.setCreatedBy(item.getCreatedBy());
        collegeSchool.setCreatedDate(item.getCreatedDate());
        collegeSchool.setOrgId(item.getOrgId());
        return collegeSchoolRepository.save(collegeSchool);
    }

    /**
     * Filter the college school name
     * @param collegeSchool
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/filter/collegeSchoolNamelist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterPullDownList(@RequestBody CollegeSchool collegeSchool) {
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }

    /**
     * Deleted the college school by Id
     * @param collegeSchool
     * @return
     */
    @ResponseBody
    @DeleteMapping(path = "/deleteCollegeSchoolNameList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteCollegeSchoolNameList(@RequestBody CollegeSchool collegeSchool) {

        long sessionOrgId = 1;
        CollegeSchool clgScl = collegeSchoolRepository.findByCollegeSchoolIdAndOrgId(collegeSchool.getCollegeSchoolId(), sessionOrgId);
        //session param
        clgScl.setDeletedBy(clgScl.getCollegeSchoolId());
        clgScl.setDeletedDate(new Date());
        CollegeSchool val = collegeSchoolRepository.save(clgScl);
        int statusCode = 200;
        String message = "success";
        if(val == null){
            statusCode = 500;
            message = "failed";
        }
        return new ResponseEntity(new Response(statusCode, message), null, HttpStatus.OK);
    }


    /**
     * Search the college school name
     * @param pathVars
     * @param reqBody
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/collegeSchoolName/search/v1/{name}/{value}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CollegeSchool>> searchCollegeSchoolNameList(@PathVariable Map<String, String> pathVars, @RequestBody String reqBody) {
        RequestDataVO requestDataVO = collegeShoolValidator.validate(RequestAPIType.PULL_DOWN_LIST_V1, reqBody, pathVars);
        String name = requestDataVO.getInputPathVars().get("name");
        String value = requestDataVO.getInputPathVars().get("value");
        List<CollegeSchool> list = new ArrayList<>();
        if (null != schoolCollegeMap.get(value)) {
            list.add(schoolCollegeMap.get(value));
            CollegeSchool pullDown = collegeSchoolServiceV1.doService(requestDataVO.getInputReqBodyString());
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    /**
     * Get the all deleted college school by name
     * @param collegeSchool
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/getDeletedCollegeSchoolByName/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CollegeSchool getDeletedCollegeSchoolByName(@RequestBody CollegeSchool collegeSchool) {
        long orgId = 1;
        CollegeSchool item = new CollegeSchool();
        if(collegeSchool.getOrgName() !=null && !collegeSchool.getOrgName().isEmpty() && collegeSchool.getOrgName().equalsIgnoreCase("College")) {
             item = collegeSchoolRepository.findDeletedCollegeByNameAndOrgId(collegeSchool.getName(), orgId);
        }else{
             item =  collegeSchoolRepository.findDeletedSchoolByNameAndOrgId(collegeSchool.getName(), orgId);
        }
        return item;
    }

    /**
     * Get the all deleted college school by name
     * @param collegeSchool
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/getDeletedCollegeSchoolByNameAndOrgId/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public long getDeletedCollegeSchoolByNameAndOrgId(@RequestBody CollegeSchool collegeSchool) {
        long orgId = 1;
        long status = 0L;
        CollegeSchool item = new CollegeSchool();
        if(collegeSchool.getOrgName() !=null && !collegeSchool.getOrgName().isEmpty() && collegeSchool.getOrgName().equalsIgnoreCase("College")) {
            item = collegeSchoolRepository.findDeletedCollegeByNameAndOrgId(collegeSchool.getName(), orgId);
        }else{
            item =  collegeSchoolRepository.findDeletedSchoolByNameAndOrgId(collegeSchool.getName(), orgId);
        }
        if(item !=null){
        status = item.getCollegeSchoolId();
        }
        return status;
    }

    /**
     * Recover the deleted item
     * @param collegeSchool
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/recoverDeletedCollegeSchool/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CollegeSchool recoverDeletedCollegeSchool(@RequestBody CollegeSchool collegeSchool) {

        //session param
        long sessionOrgId = 1;
        CollegeSchool items = collegeSchoolRepository.findDeletedCollegeSchoolByIdAndOrgId(collegeSchool.getCollegeSchoolId(),sessionOrgId);
        items.setDeletedBy(0L);
        items.setDeletedDate(null);
        CollegeSchool updatedItem =collegeSchoolRepository.save(items);
        return updatedItem;
    }

    /**
     * Update the college school name by id.
     * @param collegeSchool
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/updateCollegeSchoolNameById/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CollegeSchool updateCollegeSchoolNameById(@RequestBody CollegeSchool collegeSchool) {
        long orgId = 1;
        CollegeSchool item = collegeSchoolRepository.findByCollegeSchoolId(collegeSchool.getCollegeSchoolId(), orgId);
        item.setModifiedDate(new Date());
        item.setName(collegeSchool.getName());
        item.setOrgName(collegeSchool.getName());
        item.setModifiedBy(item.getCollegeSchoolId());
        return collegeSchoolRepository.save(item);
    }


    /**
     * Merge the old record to new record
     * @param collegeSchool
     * @return
     */
    @ResponseBody
    @DeleteMapping(path = "/mergeCollegeSchoolByName/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> mergeCollegeSchoolByName(@RequestBody CollegeSchool collegeSchool) {
       long sessionOrgId = 1;
        CollegeSchool colscl = collegeSchoolRepository.findByCollegeSchoolIdAndOrgId(collegeSchool.getCollegeSchoolId(), sessionOrgId);
        //session param
        colscl.setDeletedBy(colscl.getCollegeSchoolId());
        colscl.setDeletedDate(new Date());
        CollegeSchool value = collegeSchoolRepository.save(colscl);
        int statusCode = 200;
        String message = "success";
        if (value == null) {
            statusCode = 500;
            message = "failed";
        }
        return new ResponseEntity(new Response(statusCode, message), null, HttpStatus.OK);
    }

    /**
     * Get the college school By name
     * @param collegeSchool
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/getCollegeSchoolByName/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CollegeSchool getCollegeSchoolByName(@RequestBody CollegeSchool collegeSchool) {
        long orgId = 1;
        CollegeSchool item = new CollegeSchool();
        if(collegeSchool.getOrgName() !=null && !collegeSchool.getOrgName().isEmpty() && collegeSchool.getOrgName().equalsIgnoreCase("College")) {
            item = collegeSchoolRepository.findCollegeByNameAndOrgId(collegeSchool.getName(), orgId);
        }else{
            item =  collegeSchoolRepository.findSchoolByNameAndOrgId(collegeSchool.getName(), orgId);
        }
        return item;
    }

    /**
     * Get the college and school by code and orgId
     * @param collegeSchool
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/getCollegeSchoolByCode/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CollegeSchool getCollegeSchoolByCode(@RequestBody CollegeSchool collegeSchool) {
        long orgId = 1;
        CollegeSchool item = new CollegeSchool();
        if(collegeSchool !=null && collegeSchool.getOrgName() !=null && !collegeSchool.getOrgName().isEmpty() && collegeSchool.getOrgName().equalsIgnoreCase("College")) {
            item = collegeSchoolRepository.findCollegeByCodeAndOrgId(collegeSchool.getCodes(), orgId);
        }else{
            item =  collegeSchoolRepository.findSchoolByCodeAndOrgId(collegeSchool.getCodes(), orgId);
        }
        return item;
    }

    /**
     * Get the all college name list
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getCollegeNameList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CollegeSchool> getCollegeNameList() {
        List<CollegeSchool> list = new ArrayList<>();
        //session param
        long sessionOrgId = 1;
        Iterable<CollegeSchool> items = collegeSchoolRepository.findByOrgIdAndFafsaId(sessionOrgId);
        items.forEach(list::add);
        return list;

    }

    /**
     * Get the all school name list
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getSchoolNameList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CollegeSchool> getSchoolNameList() {
        List<CollegeSchool> list = new ArrayList<>();
        //session param
        long sessionOrgId = 1;
        Iterable<CollegeSchool> items = collegeSchoolRepository.findByOrgIdAndNcesId(sessionOrgId);
        items.forEach(list::add);
        return list;

    }
}
