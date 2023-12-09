package com.pieropan.s3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.pieropan.s3.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class AwsS3Service {

    @Autowired
    private AmazonS3 amazonS3;

    @Value("${aws.bucketName}")
    private String bucketName;

    public void realizarUpload(MultipartFile multipartFile) {
        File file = Util.toFile(multipartFile);
        criarBucket();

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, file.getName(), file);
        amazonS3.putObject(putObjectRequest);

        file.delete();
    }

    private void criarBucket() {
        boolean bucketNaoExiste = !amazonS3.doesBucketExistV2(bucketName);
        if (bucketNaoExiste) {
            amazonS3.createBucket(bucketName);
        }
    }
}