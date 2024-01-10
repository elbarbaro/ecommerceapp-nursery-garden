package com.nurserygarden.ecommerceapp.filestore;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;

public class CloudUtil {
    private AWSCredentials awsCredentials(String accessKey, String secretKey) {
        AWSCredentials credentials = new BasicAWSCredentials(
                accessKey,
                secretKey
        );
        return credentials;
    }

    private AmazonS3 awsClientBuilder(String accessKey, String secretKey) {
        AmazonS3 s3Client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials(accessKey, secretKey)))
                .withRegion(Regions.US_EAST_1)
                .build();
        return s3Client;
    }

    public void uploadFileToS3(String fileName, byte[] fileBytes, String accessKey, String secretKey, String bucket) {
        AmazonS3 s3Client = awsClientBuilder(accessKey, secretKey);

        File file = new File(fileName);

        try (OutputStream os = new FileOutputStream(file)) {

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        s3Client.putObject(bucket, fileName, file);
    }
}
