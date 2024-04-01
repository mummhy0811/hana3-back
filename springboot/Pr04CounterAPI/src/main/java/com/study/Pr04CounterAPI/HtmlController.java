package com.study.Pr04CounterAPI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HtmlController {
    @GetMapping("/")
    public String main(){

        Counter counter = new Counter(0);
        ApiController.counter=counter;

        return "index";
    }
}
