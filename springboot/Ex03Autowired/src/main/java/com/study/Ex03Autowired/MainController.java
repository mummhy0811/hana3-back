package com.study.Ex03Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String main(){
        return "스프링 부트 웹";
    }

    @Autowired
    private Member member;

    @GetMapping("/member")
    @ResponseBody
    public String member(){
        member.setName("홍길동");
        return "member 호출";
    }

    @Autowired
    @Qualifier("cardBC") //주입될 객체를 직접 지정함.
    ICard iCard; //인터페이스 구현 객체를 주입. BC와 카카오 중에 어떤 것을 주입할지 모름
    @GetMapping("/card")
    public String card(){
        member.setiCard(iCard);
        member.getiCard().buy("휴대폰");
        return "card 호출 ";
    }

}
