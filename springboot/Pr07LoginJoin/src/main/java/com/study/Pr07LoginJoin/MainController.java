package com.study.Pr07LoginJoin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    List<Member> memberList = new ArrayList<>();

    @GetMapping("/")
    public String main(){
        return "login";
    }

    @PostMapping("/join")
    public String join(@RequestParam String inputName, @RequestParam String inputEmail, @RequestParam String inputPw, Model model){
        Member member = new Member();
        member.setName(inputName);
        member.setEmail(inputEmail);
        member.setPassword(inputPw);

        memberList.add(member);

        model.addAttribute("message", "회원가입 성공!");

        return "login";
    }
    @PostMapping("/dupl")
    @ResponseBody
    public SendData dupl(@RequestBody ReceiveData data){
        boolean isDupl = false;
        for( Member member : memberList ){
            if(member.getName().equals( data.getInputName() ) ){
                isDupl = true;
                break;
            }
        }

        SendData sendData = new SendData();
        if( isDupl ){
            sendData.setStatus("no");
            sendData.setMessage("중복된 아이디가 있습니다.");
        }else {
            sendData.setStatus("ok");
            sendData.setMessage("중복된 아이디가 없습니다.");
        }
        return sendData;
    }


    @PostMapping("/login")
    public String join(@RequestParam String inputName, @RequestParam String inputPw, Model model){

        boolean isLoginOk = false;
        for(Member member : memberList){
            if( member.getName().equals(inputName) && member.getPassword().equals(inputPw) ){
                isLoginOk = true;
                break;
            }
        }
        if( isLoginOk ){
            model.addAttribute("message", "로그인 성공!");
        }else{
            model.addAttribute("message", "로그인 실패!");
        }
        System.out.println(isLoginOk);
        return "login";
    }

    @GetMapping("/join-form")
    public String joinForm(){
        return "join";
    }
}