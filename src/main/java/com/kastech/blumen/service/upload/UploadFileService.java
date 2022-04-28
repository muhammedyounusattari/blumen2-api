package com.kastech.blumen.service.upload;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class UploadFileService {

    @Value("${blumen2.storage.conn}")
    private String connectionStr;

    @Value("${blumen2.storage.container}")
    private String containerName;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public String uploadFile(String fileName, MultipartFile file) {
        LOGGER.info("request made to upload file in azure blob storage for fileName {}", fileName);
        try {
        BlobContainerClient container = new BlobContainerClientBuilder()
                .connectionString(connectionStr)
                .containerName(containerName)
                .buildClient();

        BlobClient blobClient = container.getBlobClient(fileName);
        blobClient.upload(file.getInputStream(), file.getSize(), true);
        LOGGER.info("File with name {} uploaded to azure storage successfully", fileName);
        return  blobClient.getBlobUrl();
        } catch (IOException e) {
            LOGGER.error("Problem in uploading file in blob storage {}", e);
        }
        return null;
    }

    public String getImage(String fileName){
        LOGGER.info("Request made to get file url from storage", fileName);
        return null;
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getTime());
    }
}
