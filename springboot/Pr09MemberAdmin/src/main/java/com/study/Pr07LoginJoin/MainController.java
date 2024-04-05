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

    @PostMapping("/join")
    public String join(@RequestParam String inputName, @RequestParam String inputEmail, @RequestParam String inputPw, Model model){
        Member member = new Member();
        member.setName(inputName);
        member.setEmail(inputEmail);
        member.setPassword(inputPw);
        member.setJoindate(LocalDate.now());

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

        if(inputName.equals("admin") && inputPw.equals("1234")){
            model.addAttribute("members", memberList);
            return "admin";
        }

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

    @PostMapping("/update")
    @ResponseBody
    public String update(@RequestParam int index, @RequestParam String inputName, @RequestParam String inputPw, @RequestParam String inputEmail, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inputJoindate){
        Member member = memberList.get(index);
        member.setJoindate(inputJoindate);
        member.setEmail(inputEmail);
        member.setName(inputName);
        member.setPassword(inputPw);

        memberList.set(index, member);
        return "<script>alert('수정되었습니다.'); location.href='admin-form'; </script>\"";
    }

    @GetMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam int index, Model model){
        memberList.remove(index);
        model.addAttribute("members", memberList);
        return "<script>alert('삭제되었습니다.'); location.href='admin-form'; </script>\"";
    }

    @GetMapping("/join-form")
    public String joinForm(){
        return "join";
    }
    @GetMapping("/admin-form")
    public String adminForm(Model model){
        model.addAttribute("members", memberList);
        return "admin";
    }

    @GetMapping("/edit-form")
    public String editForm(@RequestParam int index, Model model){
        model.addAttribute("index", index);
        model.addAttribute("member", memberList.get(index));
        return "edit";
    }

}