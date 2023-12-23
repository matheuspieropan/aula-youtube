package com.pieropan.s3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.pieropan.s3.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;

@Service
public class AwsS3Service {

    @Autowired
    private AmazonS3 amazonS3;

    public void realizarUpload(MultipartFile multipartFile, String cpf) {
        File file = Util.toFile(multipartFile);
        criarBucket(cpf);

        amazonS3.putObject(getPutObjectRequest(cpf, file));
        file.delete();
    }

    private static PutObjectRequest getPutObjectRequest(String cpf, File file) {
        String key = LocalDate.now().getYear() + "/" + file.getName();
        return new PutObjectRequest(cpf, key, file);
    }

    private void criarBucket(String cpf) {
        boolean bucketNaoExiste = !amazonS3.doesBucketExistV2(cpf);
        if (bucketNaoExiste) {
            amazonS3.createBucket(cpf);
        }
    }
}