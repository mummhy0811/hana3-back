package com.study.Pr07LoginJoin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    static List<Member> memberList = new ArrayList<>();

    @GetMapping("/")
    public String main(){
        return "login";
    }

    @PostMapping("/join")
    @ResponseBody
    public SendData join(@RequestBody Member member){
        memberList.add(member);
        return new SendData("ok", "회원가입 성공!");
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
    @ResponseBody
    public SendData join(@RequestBody LoginDto dto){
        boolean isLoginOk = false;

        for (Member member : memberList) {
            if (member.getName().equals(dto.getName()) && member.getPassword().equals(dto.getPassword())) {
                isLoginOk = true;
                break;
            }
        }
        SendData sendData = new SendData();
        if( !isLoginOk ){
            sendData.setStatus("no");
            sendData.setMessage("로그인 실패");
        }else {
            sendData.setStatus("ok");
            sendData.setMessage("로그인 성공!");
        }
        return sendData;
    }

    @GetMapping("/join-form")
    public String joinForm(){
        return "join";
    }
}