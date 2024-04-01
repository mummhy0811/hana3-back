package com.example.Pr02Calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    Calculator calculator;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("A", calculator.getA());
        model.addAttribute("B", calculator.getB());
        model.addAttribute("answer", calculator.getAnswer());
        return "index";
    }

    @GetMapping("/add")
    public String add(@RequestParam int a, @RequestParam int b, Model model) {
        calculator.add(a, b);
        model.addAttribute("a", calculator.getA());
        model.addAttribute("b", calculator.getB());
        model.addAttribute("answer", calculator.getAnswer());
        return "index";
    }

    @GetMapping("/sub")
    public String sub(@RequestParam int a, @RequestParam int b, Model model) {
        calculator.sub(a, b);
        model.addAttribute("a", calculator.getA());
        model.addAttribute("b", calculator.getB());
        model.addAttribute("answer", calculator.getAnswer());
        return "index";
    }

    @GetMapping("/mul")
    public String mul(@RequestParam int a, @RequestParam int b, Model model) {
        calculator.mul(a, b);
        model.addAttribute("a", calculator.getA());
        model.addAttribute("b", calculator.getB());
        model.addAttribute("answer", calculator.getAnswer());
        return "index";
    }

    @GetMapping("/div")
    public String div(@RequestParam int a, @RequestParam int b, Model model) {
        calculator.div(a, b);
        model.addAttribute("a", calculator.getA());
        model.addAttribute("b", calculator.getB());
        model.addAttribute("answer", calculator.getDivAnswer());
        return "index";
    }

}
