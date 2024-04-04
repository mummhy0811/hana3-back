package com.study.Ex14ReadDB.controller;

import com.study.Ex14ReadDB.dto.MemberSaveDto;
import com.study.Ex14ReadDB.entity.MemberEntity;
import com.study.Ex14ReadDB.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String main() {
        return "redirect:/list"; //index.html 반환
    }

    @RequestMapping("list") //get, post 둘 다 가능
    public String list(Model model) {
        List<MemberEntity> list = memberRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("listcount", list.size());
        System.out.println("size: " + list.size());
        return "index";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/joinAction")
    @ResponseBody
    public String joinAction(@ModelAttribute MemberSaveDto dto) {
        System.out.println("name: " + dto.getUserName());

        try {
            MemberEntity memberEntity = dto.toSaveEntity();
            memberRepository.save(memberEntity);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("회원가입 실패");
            return "<script>alert('회원가입 실패'); history.back();</script>";
        }
        System.out.println("회원가입 성공");
        return "<script>alert('회원가입 성공'); location.href='/list';</script>";
    }

    @GetMapping("/viewMember")
    public String viewDTO(@RequestParam Long id, Model model){
        Optional<MemberEntity> optionalMember = memberRepository.findById(id);
        if(optionalMember.isEmpty()){
            System.out.println("회원정보가 없습니다.");
            return "redirect:/list";
        }
        optionalMember.ifPresent(memberEntity -> {
            model.addAttribute("member", memberEntity.toSaveDto());
        });
        return "modifyForm";
    }

    @PostMapping("/modifyAction")
    @ResponseBody
    public String modifyAction(MemberSaveDto memberSaveDto){
        try {
            MemberEntity memberEntity = memberSaveDto.toUpdateEntity();
            memberRepository.save(memberEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return  "<script>alert('회원정보 수정 실패');history.back();</script>";
        }

        return "<script>alert('회원정보 수정 성공');location.href='/list'</script>";
    }

    @GetMapping("/deleteMember")
    @ResponseBody
    public String deleteMember(@RequestParam long id){
        Optional<MemberEntity> optionalMember = memberRepository.findById(id);
        if(optionalMember.isEmpty()){
            return "<script>alert('회원정보 조회 실패');history.back();</script>";
        }

        MemberEntity memberEntity = optionalMember.get();
        try {
            memberRepository.delete(memberEntity);
        } catch (Exception e) {
            return "<script>alert('회원정보 삭제 실패');history.back();</script>";
        }
        return "<script>alert('회원정보 삭제 성공');location.href='/list'</script>";
    }
}
