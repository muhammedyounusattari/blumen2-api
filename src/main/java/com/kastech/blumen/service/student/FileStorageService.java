package com.kastech.blumen.service.student;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    Resource loadFileAsResource(String fileName, Long id);

    String storeFile(MultipartFile file, Long id);
}
