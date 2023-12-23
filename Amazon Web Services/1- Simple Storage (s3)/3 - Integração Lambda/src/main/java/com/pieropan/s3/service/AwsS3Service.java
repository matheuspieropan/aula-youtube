package com.pieropan.s3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.pieropan.s3.config.AwsProperties;
import com.pieropan.s3.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class AwsS3Service {

    @Autowired
    private AmazonS3 amazonS3;

    @Autowired
    private AwsProperties awsProperties;

    public void realizarUpload(MultipartFile multipartFile) {
        File file = Util.toFile(multipartFile);
        criarBucket(awsProperties.getBucketName());

        amazonS3.putObject(getPutObjectRequest(awsProperties.getBucketName(), file));
        file.delete();
    }

    private static PutObjectRequest getPutObjectRequest(String bucketName, File file) {
        String key = "images/" + file.getName();
        return new PutObjectRequest(bucketName, key, file);
    }

    private void criarBucket(String bucketName) {
        boolean bucketNaoExiste = !amazonS3.doesBucketExistV2(bucketName);
        if (bucketNaoExiste) {
            amazonS3.createBucket(bucketName);
        }
    }
}