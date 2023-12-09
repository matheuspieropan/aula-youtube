package com.pieropan.s3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.pieropan.s3.Util;
import com.pieropan.s3.config.AwsProperties;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@AllArgsConstructor
@Service
public class AwsService {

    @Autowired
    private AmazonS3 amazonS3;

    private final AwsProperties awsProperties;

    public void realizarUpload(MultipartFile multipartFile) {
        File file = Util.toFile(multipartFile);
        criarBucket();
        amazonS3.putObject(criarPutObjectRequest(file));
        file.delete();
    }

    private void criarBucket() {
        boolean bucketNaoCriado = !amazonS3.doesBucketExistV2(awsProperties.getBucketName());
        if (bucketNaoCriado) {
            amazonS3.createBucket(awsProperties.getBucketName());
        }
    }

    private PutObjectRequest criarPutObjectRequest(File file) {
        return new PutObjectRequest(awsProperties.getBucketName(), file.getName(), file);
    }
}