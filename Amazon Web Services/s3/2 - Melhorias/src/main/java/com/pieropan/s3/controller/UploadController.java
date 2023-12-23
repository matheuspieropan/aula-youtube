package com.pieropan.s3.controller;

import com.pieropan.s3.service.AwsS3Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
@RequestMapping("/upload")
public class UploadController {

    private final AwsS3Service awsS3Service;

    @PostMapping
    public String realizarUpload(@RequestParam("file") MultipartFile multipartFile,
                                 @RequestParam("cpf") String cpf) {
        awsS3Service.realizarUpload(multipartFile, cpf);
        return "OK";
    }
}