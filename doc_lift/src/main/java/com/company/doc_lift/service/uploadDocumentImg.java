package com.company.doc_lift.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class uploadDocumentImg {

    @Value("${upload.path}")
    private String uploadPath;

    public String getPathImg(MultipartFile file) throws IOException {
        File uploadDir = new File(uploadPath);

        if(!uploadDir.exists()){
            uploadDir.mkdir();
        }

        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = uuidFile + "." + file.getOriginalFilename();

        file.transferTo(new File(uploadPath + "/" + resultFileName));

        return resultFileName;
    }
}
