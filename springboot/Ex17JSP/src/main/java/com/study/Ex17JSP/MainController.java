package com.study.Ex17JSP;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(){
        return "ex01";
    }

    @GetMapping("/ex/{no}")
    public String ex(@PathVariable String no){
        return "ex"+no;
    }
}
