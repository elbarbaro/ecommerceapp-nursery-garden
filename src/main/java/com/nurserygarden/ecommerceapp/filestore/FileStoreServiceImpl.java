package com.nurserygarden.ecommerceapp.filestore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@Service
public class FileStoreServiceImpl {

    @Value("${aws.access.key}")
    private String AWS_ACCESS_KEY;
    @Value("${aws.secret.key}")
    private String AWS_SECRET_KEY;
    @Value("${aws.bucket}")
    private String AWS_BUCKET;

    public String uploadMultipartFileS3(MultipartFile image) {
        AwsCloudUtil util = new AwsCloudUtil();

        try {
            util.uploadFileToS3(image.getOriginalFilename(), image, AWS_ACCESS_KEY, AWS_SECRET_KEY, AWS_BUCKET);
            return String.format("File %s uploaded succesfully", image.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.format("File %s uploadeded failed", image.getOriginalFilename());
    }

}
