package com.nurserygarden.ecommerceapp.filestore;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class FileStoreServiceImpl {

    private AmazonS3 awsClient;

    private FileStoreServiceImpl(AmazonS3 awsClient) {
        this.awsClient = awsClient;
    }

    @Value("${aws.bucket}")
    public String AWS_BUCKET;

    public String uploadMultipartFileS3(MultipartFile image) {

        try {
            uploadFileToS3(image.getOriginalFilename(), image, AWS_BUCKET);

            return String.format("File %s uploaded succesfully", image.getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.format("File %s uploadeded failed", image.getOriginalFilename());
    }

    public void uploadFileToS3(String fileName, MultipartFile image, String bucket) throws IOException {

        File file = new File(fileName);

        try (OutputStream os = new FileOutputStream(file)) {
            os.write(image.getBytes());

            awsClient.putObject(bucket, fileName, file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
