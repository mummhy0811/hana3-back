package com.study.Ex22TD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class APIController {

    @Autowired
    MemberService memberService;

    @PostMapping("/loginAction1")
    public ResultDto loginAction1(@RequestParam String loginId, @RequestParam String loginPw){
        Member member = Member.builder()
                .loginId(loginId)
                .loginPw(loginPw)
                .build();

        int result = memberService.loginAction(member);
        ResultDto resultDto = new ResultDto();
        if( result == 1 ){
            resultDto.setStatus("ok");
            resultDto.setMessage("로그인 성공!");
        }else{
            resultDto.setStatus("fail");
            resultDto.setMessage("로그인 실패!");
        }

        return resultDto;
    }
}
