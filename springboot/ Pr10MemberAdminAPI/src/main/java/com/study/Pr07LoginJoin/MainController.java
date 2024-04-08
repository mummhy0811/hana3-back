package com.study.Pr07LoginJoin;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    List<Member> memberList = new ArrayList<>();
    public MainController(){
        memberList.add(new Member("a", "abc", "1234", LocalDate.now()));
    }
    @GetMapping("/")
    public String main(){
        return "login";
    }

    @GetMapping("/join-form")
    public String joinForm(){
        return "join";
    }
    @GetMapping("/admin-form")
    public String adminForm(){
        return "admin";
    }
    @GetMapping("/edit-form")
    public String editForm(@RequestParam int index, Model model){
        model.addAttribute("index", index);
        model.addAttribute("member", memberList.get(index));
        return "edit";
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
        SendData sendData = new SendData();
        if(dto.getName().equals("admin") && dto.getPassword().equals("1234")){
            sendData.setStatus("ok");
            sendData.setMessage("관리자 페이지로 이동");
            return sendData;
        }
        boolean isLoginOk = false;

        for (Member member : memberList) {
            if (member.getName().equals(dto.getName()) && member.getPassword().equals(dto.getPassword())) {
                isLoginOk = true;
                break;
            }
        }
        if( !isLoginOk ){
            sendData.setStatus("no");
            sendData.setMessage("로그인 실패");
        }else {
            sendData.setStatus("ok");
            sendData.setMessage("로그인 성공!");
        }
        return sendData;
    }

    @PutMapping("/update")
    @ResponseBody
    public SendData update( @RequestBody UpdateMemberDto dto){

        Member member = new Member();

        member.setJoindate(dto.getJoindate());
        member.setEmail(dto.getEmail());
        member.setName(dto.getName());
        member.setPassword(dto.getPassword());

        memberList.set(dto.getIndex(), member);
        return SendData.builder().status("ok").message("수정되었습니다.").build();
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public SendData delete(@RequestParam int index){
        memberList.remove(index);

        return SendData.builder().status("ok").message("삭제되었습니다.").build();
    }

    @GetMapping("/members")
    @ResponseBody
    public List<Member> members(){
        return memberList;
    }

    @GetMapping("/member")
    @ResponseBody
    public Member member(@RequestParam int index){
        return memberList.get(index);
    }

}