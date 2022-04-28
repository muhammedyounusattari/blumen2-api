package com.kastech.blumen.service.staff;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.kastech.blumen.model.Address;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.staff.Staff;
import com.kastech.blumen.repository.staff.StaffRepository;
import com.kastech.blumen.service.upload.UploadFileService;
import com.kastech.blumen.utility.CommonUtil;

import com.kastech.blumen.utility.DateUtil;
import com.kastech.blumen.utility.SecurityUtil;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StaffServiceV1 {

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    UploadFileService uploadFileService;

    @Value("classpath:images")
    Resource resourceFile;



    private static final Logger LOGGER = LoggerFactory.getLogger(StaffServiceV1.class);

    public Staff doService(String reqBody){

        Staff staff = CommonUtil.convertJsonStringToPojoForStaff(reqBody);


        return staff;
    }

    public String getFileExtention(String staffId) {
        File folder = new File("src/main/resources/images/"+staffId);
        for(File file:folder.listFiles()){
            return FilenameUtils.getExtension(file.getName());//.split(".")[0];
        }
        return "";
    }

    public Staff uplaodFile(MultipartFile file, Long staffId) throws IOException {
        LOGGER.info("File upload is {} and staffId {} ", file, staffId);

        //for staff file upload ==> Staff_orgId_userId_staff_Id.extension;
        String fileName = "staff"+"_"+SecurityUtil.getUserOrgId()+"_"+SecurityUtil.getUserId()+"_"+staffId+"."+FilenameUtils.getExtension(file.getOriginalFilename());
        fileName = uploadFileService.uploadFile(fileName,file);

        Staff staff = new Staff();
        Optional<Staff> staffs = staffRepository.findById(staffId);
        //code create staffId
        if(staffs.isEmpty()){
            staff.setId(staffId);
            staff =  staffRepository.save(staff);
        } else {
            staff = staffs.get();
        }
        staff.setStaffPicture(fileName);
        staff.setCreatedBy(SecurityUtil.getUserId());
        staff.setCreatedDate(DateUtil.setDates(0));
        staff.setOrgId(SecurityUtil.getUserOrgId());
        staffId =  staffRepository.save(staff).getId();

        return staff;
    }

    public byte[] getFile(String staffId) throws IOException {
         byte []bytes = null;
        try {
            var imgFile = new ClassPathResource("images/"+staffId+"/"+staffId+"."+getFileExtention(staffId));
            bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
        } catch (IOException e) {
           throw new IOException("FileNotFound ");
        }
        return bytes;
    }

    public List<Staff> validatePhoneNumber() {
        List<Staff> updatedStaffList = new ArrayList<>();
        for(Staff staff: staffRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))){
            for(Address address: staff.getAddress()){
                if(address.getPermanentAddress()!=null && address.getPermanentAddress()){
                    staff.setStaffPhoneNumber(address.getStaffPhone1());
                }
            }
            updatedStaffList.add(staff);
        }
        return updatedStaffList;
    }
}
