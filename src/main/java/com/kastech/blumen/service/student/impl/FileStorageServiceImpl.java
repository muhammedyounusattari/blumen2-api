package com.kastech.blumen.service.student.impl;

import com.kastech.blumen.config.FileStorageProperties;
import com.kastech.blumen.exception.CustomFileNotFoundException;
import com.kastech.blumen.exception.FileStorageException;
import com.kastech.blumen.service.student.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;


@Service
public class FileStorageServiceImpl implements FileStorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileStorageServiceImpl.class);

//    @Autowired
//    private FileStorageProperties fileStorageProperties;

    private  Path fileStorageLocation;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public Resource loadFileAsResource(String fileName,Long id) {
        try {
            String fileDirectory = "";
            this.fileStorageLocation = Paths.get(uploadDir)
                    .toAbsolutePath().normalize();
            fileDirectory = "/" + id;
            String finalDirectory = this.fileStorageLocation + fileDirectory;
            Path path = Paths.get(finalDirectory);

            Path filePath = path.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                LOGGER.info("resource exists "+ resource.getFilename());
                return resource;
            } else {
                LOGGER.info("resource does not exists ");
                throw new CustomFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new CustomFileNotFoundException("File not found " + fileName, ex);
        }
    }

    @Override
    public String storeFile(MultipartFile file, Long id) {
        this.fileStorageLocation = Paths.get(uploadDir)
                .toAbsolutePath().normalize();

        String fileDirectory = "/" + id;
        String finalDirectory = this.fileStorageLocation + fileDirectory;
        Path path = Paths.get(finalDirectory);
        if (!Files.exists(path)) {
            try {
                LOGGER.info("the value of file storage location is "+ this.fileStorageLocation);
                Files.createDirectories(path);
            } catch (Exception ex) {
                throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
            }
        }
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String[] fileNameArray = fileName.split("\\.");
        fileName = fileNameArray[0] + "_" + System.currentTimeMillis() + "." + fileNameArray[1];
        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Path targetLocation = path.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
}
