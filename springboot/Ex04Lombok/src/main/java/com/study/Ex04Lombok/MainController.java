package com.study.Ex04Lombok;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String main(){
        return "롬복 예제입니다";
    }

    //필드주입
    @Autowired
    private Member member;
    //생성자 주입
    private final Member member2;
    
    //RequiredArgsConstructor가 아래 코드를 대신함
//    @Autowired
//    public MainController(Member member){
//        this.member2=member;
//    }
}
