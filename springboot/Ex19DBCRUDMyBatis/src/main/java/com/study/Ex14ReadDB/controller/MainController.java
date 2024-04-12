package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.dao.IMemberDao;
import com.study.Ex14ReadDB.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {
    //생성자 주입
    final IMemberDao memberDao;

    @GetMapping("/")
    public String main(){
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<MemberDto> list = memberDao.list();
        model.addAttribute("list", list);
        model.addAttribute("listcount", memberDao.count());

        return "index";
    }
    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/joinAction")
    @ResponseBody
    public String joinAction(@ModelAttribute MemberDto dto){

        try {

            int result = memberDao.insert(dto);
            if(result!=1) return "<script>alert('회원가입 실패');history.back();</script>";
        }
        catch (Exception e){
            e.printStackTrace();
            return "<script>alert('회원가입 실패');history.back();</script>";
        }

        return "<script>alert('회원가입 성공');location.href='/list';</script>";
    }

    @GetMapping("/viewMember")
    public String view(@RequestParam long id, Model model) {
        Optional<MemberDto> optional = memberDao.findById(id);
        if(optional.isPresent()){
            model.addAttribute("member", optional.get());
            return "modifyForm";
        }
        System.out.println("회원 정보가 없습니다.");
        return "redirect:/";
    }


    @PostMapping("/modifyAction")
    @ResponseBody
    public String modifyAction(@ModelAttribute MemberDto dto){
        try{
           int result = memberDao.update(dto);
           if(result!=1){
               System.out.println("회원 정보 수정 실패");
               return "<script>alert('회원정보수정 실패');history.back();</script>";
           }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("회원정보수정 실패");
            return "<script>alert('회원정보수정 실패');history.back();</script>";
        }
        System.out.println("회원정보수정 성공");
        return "<script>alert('회원정보수정 성공');location.href='/list';</script>";
    }

    @GetMapping("/deleteMember")
    @ResponseBody
    public String deleteMember(@RequestParam int id){
        Optional<MemberDto> optional = memberDao.findById((long)id);
        if( !optional.isPresent() ){
            System.out.println("회원정보조회 실패");
            return "<script>alert('회원정보조회 실패');history.back();</script>";
        }

        try{
            memberDao.delete( id );
        }catch (Exception e){
            e.printStackTrace();
            return "<script>alert('회원정보삭제 실패');history.back();</script>";
        }
        return "<script>alert('회원정보삭제 성공');location.href='/list';</script>";
    }
}



