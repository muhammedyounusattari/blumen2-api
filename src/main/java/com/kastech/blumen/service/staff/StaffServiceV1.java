package com.kastech.blumen.service.staff;

import com.kastech.blumen.model.Address;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.staff.Staff;
import com.kastech.blumen.repository.staff.StaffRepository;
import com.kastech.blumen.utility.CommonUtil;
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
import java.util.ArrayList;
import java.util.List;

@Component
public class StaffServiceV1 {

    @Autowired
    StaffRepository staffRepository;

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

    public Long uplaodFile(MultipartFile file, Long staffId) throws IOException {
        LOGGER.info("File upload is {} and staffId {} ", file, staffId);
        if(staffId == 0){
            staffId = 9999999l;
        }
        //code create staffId
        if(staffRepository.findById(staffId).isEmpty()){
            Staff staff = new Staff();
            staffId =  staffRepository.save(staff).getId();
        }
       String classPath =  this.getClass().getClassLoader().getName();
        String extention = FilenameUtils.getExtension(file.getOriginalFilename());
        String filePath = "C:\\Users\\default.DESKTOP-9B0VHF3\\kastech\\blumen_2.0\\src\\main\\resources\\images\\"+staffId+"\\"+staffId+"." + extention;


        File newFile  =new File(filePath);
        try {
            if (newFile.exists() || newFile.mkdirs()) {
                file.transferTo(newFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }
        return staffId;
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
                    updatedStaffList.add(staff);
                } else {
                    updatedStaffList.add(staff);
                }
            }
        }
        return updatedStaffList;
    }
}
