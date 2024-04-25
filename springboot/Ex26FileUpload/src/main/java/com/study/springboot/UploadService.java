package com.study.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class UploadService {
    @Value("${spring.servlet.multipart.location}")
    private String CKImageFolder;
    @Value("/upload/")
    private String ckImagePath;

    public CKResponse ckImageUpload(MultipartFile image){
        if( image != null && !image.isEmpty()){
            String imageName = UUID.randomUUID() + "-" + image.getOriginalFilename();
            File file = new File(CKImageFolder, imageName);
            try{
                image.transferTo(file);
            }catch (Exception e){
                e.printStackTrace();
            }
            return new CKResponse(1, imageName, ckImagePath + imageName);
        }
        return null;
    }
}