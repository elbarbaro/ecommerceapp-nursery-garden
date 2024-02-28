package com.nurserygarden.ecommerceapp.filestore;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

@Service
public class FileStoreServiceImpl {

    private AmazonS3 awsClient;

    private FileStoreServiceImpl(AmazonS3 awsClient) {
        this.awsClient = awsClient;
    }

    @Value("${aws.bucket}")
    public String AWS_BUCKET;

    public String uploadMultipartFileS3(MultipartFile image, Long id) throws IOException {

        String path = "\\" + id + "\\" + image.getOriginalFilename();

        uploadFileToS3(image.getOriginalFilename(), image, AWS_BUCKET, path);

        String url = generatePresignedGetUrl(image.getOriginalFilename());

        return url;
    }

    public void uploadFileToS3(String fileName, MultipartFile image, String bucket, String path) throws IOException {


        File file = new File(fileName);

        try (OutputStream os = new FileOutputStream(file)) {
            os.write(image.getBytes());

            awsClient.putObject(bucket, path, file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String generatePresignedGetUrl(String fileName) {

        String objectKey = fileName;

        java.util.Date expiration = new java.util.Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 10;
        expiration.setTime(expTimeMillis);

        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(AWS_BUCKET, objectKey)
                        .withMethod(HttpMethod.GET)
                        .withExpiration(expiration);
        URL url = awsClient.generatePresignedUrl(generatePresignedUrlRequest);

        return url.toString();

    }

}