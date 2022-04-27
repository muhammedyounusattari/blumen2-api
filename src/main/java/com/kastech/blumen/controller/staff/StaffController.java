package com.kastech.blumen.controller.staff;

import com.google.gson.Gson;
import com.kastech.blumen.constants.RestURIConstant;
import com.kastech.blumen.model.Address;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.customize.GradingGroupList;
import com.kastech.blumen.model.customize.GradingList;
import com.kastech.blumen.model.staff.Staff;
import com.kastech.blumen.repository.staff.StaffRepository;
import com.kastech.blumen.service.staff.StaffServiceV1;
import com.kastech.blumen.utility.SecurityUtil;
import com.kastech.blumen.validator.staff.StaffValidator;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/blumen-api/staff")
public class StaffController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    StaffServiceV1 staffServiceV1;

    @Autowired
    StaffValidator staffValidator;

    @ResponseBody
    @GetMapping(path = "/getStaffList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Staff Data Filter/ Entry_R', 'Staff Data Filter/ Entry_Y')")
    public List<Staff> getStaffList() {

        List<Staff> list = new ArrayList<>();
        //session param
        long sessionOrgId = SecurityUtil.getUserOrgId();
        Iterable<Staff> items = staffRepository.findByOrgId(sessionOrgId);
        items.forEach(list::add);
        return list;
    }


    @ResponseBody
    @PostMapping(path = "/staffList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Staff Data Filter/ Entry_Y')")
        public Staff addToStaffList(@RequestBody Staff staff) {
        System.out.println(staff);
        //session param
        long sessionOrgId = SecurityUtil.getUserOrgId();
        staff.setOrgId(sessionOrgId);
        staff.setCreatedDate(new Date());
        staff.setCreatedBy(SecurityUtil.getUserId());
        return staffRepository.save(staff);
    }

    @ResponseBody
    @PutMapping(path = "/updateStaffList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Staff Data Filter/ Entry_Y')")
    public Staff editStaffList(@RequestBody Staff staff) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        Staff item = staffRepository.findByIdAndOrgId(staff.getId(), sessionOrgId);

        staff.setModifiedDate(new Date());
        staff.setModifiedBy(SecurityUtil.getUserId());
        staff.setCreatedBy(item.getCreatedBy());
        staff.setCreatedDate(item.getCreatedDate());
        staff.setOrgId(item.getOrgId());
        return staffRepository.save(staff);
    }




	@ResponseBody
	@PutMapping(path = "/filter/stafflist/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
    @PreAuthorize("hasAnyAuthority('Staff Data Filter/ Entry_R','Staff Data Filter/ Entry_Y')")
	public ResponseEntity<String> filterStaffList(@RequestBody Staff staff) {
		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(staffRepository.findById(staff.getId())));
	}


    @ResponseBody
    @DeleteMapping(path = "/deleteStaffList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Staff Data Filter/ Entry_Y')")
    public ResponseEntity<String> deleteStaffList(@RequestBody Staff staff) {

        long sessionOrgId = SecurityUtil.getUserOrgId();
        Staff stff = staffRepository.findByIdAndOrgId(staff.getId(), sessionOrgId);
        //session param
        stff.setDeletedBy(SecurityUtil.getUserId());
        stff.setDeletedDate(new Date());
        Staff value = staffRepository.save(stff);
        int statusCode = 200;
        String message = "success";
        if (value == null) {
            statusCode = 500;
            message = "failed";
        }
        return new ResponseEntity(new Response(statusCode, message), null, HttpStatus.OK);
    }



    @PostMapping(value = RestURIConstant.FILE_UPLOAD, consumes = "multipart/form-data")
    @PreAuthorize("hasAnyAuthority('Staff Data Filter/ Entry_Y')")
    public ResponseEntity<?> uploadFileMulti(@PathVariable(name = "staffId", required = true) Long staffId,
                                             @RequestParam("uploadfile") MultipartFile file) {
        if(file.isEmpty()){
            LOGGER.error("file tried to upload is empty {}", file);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Map<String, Long> resultMap = new HashMap<>();
        try {
            //TODO - replace system upload with
           staffId = staffServiceV1.uplaodFile(file,staffId);
           resultMap.put("staffId", staffId);
        } catch ( IOException e) {
            return  new ResponseEntity<>(new Response(500, "failure"), null, HttpStatus.BAD_REQUEST);
        } catch(Exception e){
            return  new ResponseEntity<>(new Response(500, "failure"), null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(staffId, HttpStatus.OK);
    }


    @RequestMapping(value = RestURIConstant.FILE_UPLOAD, method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    @PreAuthorize("hasAnyAuthority('Staff Data Filter/ Entry_R','AStaff Data Filter/ Entry_Y')")
    public ResponseEntity<byte[]> getImage(@PathVariable("staffId") String staffId) throws IOException {

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(staffServiceV1.getFile(staffId));
    }

    /**
     * Get the max staff list by orgId
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getMaxStaffId/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Staff Data Filter/ Entry_R','Staff Data Filter/ Entry_Y')")
    public Long getMaxStaffListId() {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        return staffRepository.getMaxId(sessionOrgId);
    }

    /**
     * Get the deleted grading By id
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getDeletedStaffByStaffId/v1/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Staff Data Filter/ Entry_Y')")
    public Staff getDeletedStaffByStaffId(@PathVariable long id) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        Staff item = staffRepository.findDeletedStaffByStaffIdAndOrgId(id, sessionOrgId);
        return item;
    }


    /**
     * Recover the deleted staff by Id
     * @param staff
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/recoverDeletedStaffByStaffId/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Staff Data Filter/ Entry_Y')")
    public Staff recoverDeletedStaffByStaffId(@RequestBody Staff staff) {

        //session param
        long sessionOrgId = SecurityUtil.getUserOrgId();
        Staff items = staffRepository.findDeletedStaffByStaffIdAndOrgId(staff.getStaffId(),sessionOrgId);
        items.setDeletedBy(0L);
        items.setDeletedDate(null);
        Staff updatedItem =staffRepository.save(items);
        return updatedItem;
    }

    /**
     * Update the staff by id
     * @param staff
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/updateStaffByStaffId/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Staff Data Filter/ Entry_Y')")
    public Staff updateStaffByStaffId(@RequestBody Staff staff) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        Staff item = staffRepository.findByStaffId(staff.getTempId(), sessionOrgId);
        item.setModifiedDate(new Date());
        item.setModifiedBy(SecurityUtil.getUserId());
        item.setStaffId(staff.getStaffId());
        return staffRepository.save(item);
    }

    /**
     * Merge the staff by id
     * @param staff
     * @return
     */
    @ResponseBody
    @DeleteMapping(path = "/mergeStaffByStaffId/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Staff Data Filter/ Entry_Y')")
    public ResponseEntity<?> mergeStaffByStaffId(@RequestBody Staff staff) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        Staff stff = staffRepository.findByStaffIdAndOrgId(staff.getStaffId(), sessionOrgId);
        //session param
        stff.setDeletedBy(SecurityUtil.getUserId());
        stff.setDeletedDate(new Date());
        Staff value = staffRepository.save(stff);
        int statusCode = 200;
        String message = "success";
        if (value == null) {
            statusCode = 500;
            message = "failed";
        }
        return new ResponseEntity(new Response(statusCode, message), null, HttpStatus.OK);
    }

    /**
     * get the all gradingGroup By GradingGroupName And GradingGroupType
     * @param staffName
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/getStaffNameByOrgId/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Staff Data Filter/ Entry_R','Staff Data Filter/ Entry_Y')")
    public Staff getStaffNameByOrgId(@RequestBody String staffName) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        return staffRepository.findByStaffNameAndOrgId(staffName, sessionOrgId);
    }
}
