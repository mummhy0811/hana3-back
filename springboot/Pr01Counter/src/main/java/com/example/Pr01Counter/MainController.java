package com.example.Pr01Counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private Counter counter;
    @GetMapping("/")
    public String main(){
        return "redirect:index";
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("count", 0);
        return "index";
    }
    @GetMapping("/plus")
    public String plus(Model model){
        counter.plus();
        model.addAttribute("count", counter.getCount() );
        return "index";
    }
    @GetMapping("/minus")
    public String minus(Model model){
        counter.minus();
        model.addAttribute("count", counter.getCount());
        return "index";
    }
}
