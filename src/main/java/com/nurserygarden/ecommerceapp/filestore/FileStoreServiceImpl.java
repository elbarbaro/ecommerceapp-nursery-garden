package com.nurserygarden.ecommerceapp.filestore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class FileStoreServiceImpl {

    @Value("${access.key}")
    private String ACCESS_KEY;
    @Value("${secret.key}")
    private String SECRET_KEY;
    @Value("${bucket}")
    private String BUCKET;

    public String uploadMultipartFileS3(MultipartFile image) {
        CloudUtil util = new CloudUtil();
        try {
            util.uploadFileToS3(image.getOriginalFilename(), image.getBytes(), ACCESS_KEY, SECRET_KEY, BUCKET);
            return String.format("File %s uploaded succesfully", image.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.format("File %s uploadeded failed", image.getOriginalFilename());
    }

}
