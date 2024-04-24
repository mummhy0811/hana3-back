package com.study.springboot.controller;

import com.study.springboot.dto.MemberJoinDto;
import com.study.springboot.entity.MemberEntity;
import com.study.springboot.entity.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm"; //loginForm.html로 응답
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/joinAction")
    @ResponseBody
    public String joinAction(@Valid @ModelAttribute MemberJoinDto dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String detail = bindingResult.getFieldError().getDefaultMessage();
            String bindResultCode = bindingResult.getFieldError().getCode();
            System.out.println(detail+":"+bindResultCode);
            return "<script>alert('"+detail+"'); history.back();</script>";
        }
        String encodePassword = passwordEncoder.encode(dto.getPassword());
        log.info("encodePassword:"+encodePassword);
        dto.setPassword(encodePassword);

        try {
            MemberEntity entity = dto.toSaveEntity();
            memberRepository.save(entity);
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            return "";
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return "<script>alert('회원가입 실패'); history.back()';</script>";
        }

        HttpStatus status = HttpStatus.OK;
        if(status==HttpStatus.OK){
            return "<script>alert('회원가입 성공'); location.href='loginForm';</script>";
        }else{
            return "<script>alert('회원가입 실패'); history.back()';</script>";

        }
    }

    @GetMapping("/admin")
    public String admin(Model model){
        long listCount = memberRepository.count();
        model.addAttribute("listCount", listCount);
        List<MemberEntity> list = memberRepository.findAll();
        model.addAttribute("list", list);

        return "admin";
    }

    @RequestMapping("/viewDTO")
    public String viewDTO(@RequestParam("id") int id, Model model) throws Exception {
        Optional<MemberEntity> optional = memberRepository.findById(Long.valueOf(id));
        if(optional.isEmpty()) {
            throw new Exception("member id is wrong!");
        }
        MemberEntity entity = optional.get();
        model.addAttribute("member", entity);

        return "modifyForm";
    }
    @RequestMapping("/modifyAction")
    @ResponseBody
    public String modifyAction(@ModelAttribute MemberJoinDto memberJoinDto) {

        try{
            MemberEntity entity = memberJoinDto.toUpdateEntity();
            memberRepository.save( entity );
        }
        catch ( IllegalArgumentException e ){
            e.printStackTrace();
            return "<script>alert('회원정보 수정 실패'); history.back();</script>";
        }

        return "<script>alert('회원정보 수정 성공!'); location.href='/viewDTO?id=" + memberJoinDto.getId() + "';</script>";
    }
    @RequestMapping("/deleteDTO")
    @ResponseBody
    public String deleteDTO(@RequestParam("id") int id) throws Exception {

        Optional<MemberEntity> optional = memberRepository.findById(Long.valueOf(id));
        if(optional.isEmpty()) {
            throw new Exception("member id is wrong!");
        }
        MemberEntity entity = optional.get();

        try{
            memberRepository.delete( entity );
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            return "<script>alert('회원정보 삭제 실패'); history.back();</script>";
        }
        return "<script>alert('회원정보 삭제 성공'); location.href='/admin';</script>";
    }
}
