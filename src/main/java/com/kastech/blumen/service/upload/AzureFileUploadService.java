package com.kastech.blumen.service.upload;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AzureFileUploadService {

  public String uploadFile(MultipartFile file){
      String constr = "DefaultEndpointsProtocol=https;AccountName=blumen2;AccountKey=eUnBJrpVF17YJbFvNVjAdi2LwD3ZUk9KN51cgT8sxE6J9oBXvBWlfoDpMzbQ7k60jZ1YTH/x9Zf2+AStq3qMgA==;EndpointSuffix=core.windows.net";
return constr;
     // BlobContainerClient container =
  }
}
