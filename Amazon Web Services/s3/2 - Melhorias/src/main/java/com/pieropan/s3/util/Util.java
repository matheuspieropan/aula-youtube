package com.pieropan.s3.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class Util {

    public static File toFile(MultipartFile multipartFile) {
        File file = new File(multipartFile.getOriginalFilename());

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Files.copy(inputStream, file.toPath());
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}