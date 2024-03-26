package com.study.Ex02SpringDI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String main(){
        return "스프링부트 웹 애플리케이션 첫 응답!";
    }

    //스프링 빈을 주입받는 방법
    //1. 필드 주입
    //@Autowired: 스프링 빈을 주입해주는 어노테이션.
    @Autowired
    private Member member1;
    @Autowired
    private Member member2;
    @GetMapping("/field")
    @ResponseBody
    public String field(){
        System.out.println("member1: "+member1);//싱글톤 유지
        System.out.println("member2: "+member2);//싱글톤 유지
        return "field()호출됨";
    }

    //2. 수정자 주입
    private Member member3;
    @Autowired
    public void setMember(Member member){
        this.member3=member;
    }
    @GetMapping("/setter")
    @ResponseBody
    public String setter(){
        return "setter 호출";
    }

    //3. 생성자 주입
    private final Member member4;
    @Autowired
    public MainController(Member member){
        this.member4=member;
    }
    @GetMapping("/constructor")
    @ResponseBody
    public String constructor(){
        return "constructor() 호출됨";
    }
}
