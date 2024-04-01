package com.study.Pr04CounterAPI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HtmlController {
    @GetMapping("/")
    public String main(){
        ApiController.counter= new Counter(0);

        return "index";
    }
}
