package com.study.Ex12H2DB;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MemberRepository memberRepository;
    @GetMapping("/")
    public String main(Model model){
        memberRepository.save(new MemberEntity(1L, "hong", "1234", "홍길동","ROLE_USER", LocalDate.now()));
        memberRepository.save(new MemberEntity(2L, "tom", "1234", "톰","ROLE_USER", LocalDate.now()));
        memberRepository.save(new MemberEntity(3L, "admin", "1234", "관리자","ROLE_ADMIN", LocalDate.now()));

        List<MemberEntity> members = memberRepository.findAll();
        model.addAttribute("list", members);
        return "index";
    }
}
