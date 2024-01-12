package com.nurserygarden.ecommerceapp.filestore;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AwsCloudUtil {
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

    public void uploadFileToS3(String fileName, MultipartFile image, String accessKey, String secretKey, String bucket) throws IOException {
        AmazonS3 s3Client = awsClientBuilder(accessKey, secretKey);

        File file = new File(fileName);

        try (OutputStream os = new FileOutputStream(file)) {
            os.write(image.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        s3Client.putObject(bucket, fileName, file);
    }
}
