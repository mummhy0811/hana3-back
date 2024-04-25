package com.study.springboot;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final UploadService uploadService;
    @GetMapping("/")
    public String main(){
        return "upload";
    }
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile[] uploadfile, Model model) throws IOException {
        List<FileDto> list = new ArrayList<>();
        for( MultipartFile file : uploadfile ){
            if(!file.isEmpty()){
                //FileDto 정보 생성
                FileDto dto = new FileDto(UUID.randomUUID().toString(),
                        file.getOriginalFilename(), //myImage.png
                        file.getContentType()); //jpg, png
                list.add( dto );

                File newFileName = new File(dto.getUuid() + "_" + dto.getFileName());
                //전달한 내용을 실제 물리적인 파일로 저장한다.
                file.transferTo( newFileName );
            }
        }

        model.addAttribute("files", list);
        return "result"; //result.html로 응답
    }
    @GetMapping("/result")
    public String result(HttpSession session){
        return "result"; //result.html로 응답
    }

    @GetMapping("/ckeditor4")
    public String ckeditor4(){
        return "upload_ckeditor4";
    }

    @PostMapping("/ckUpload")
    @ResponseBody
    public ResponseEntity<CKResponse> ckImageUpload(MultipartFile upload){
        CKResponse ckResponse = uploadService.ckImageUpload(upload);
        return ResponseEntity.ok(ckResponse);
    }
}
