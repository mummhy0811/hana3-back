package com.example.Pr01Counter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HtmlController {
    final Calculator calculator;

    @GetMapping("/")
    public String main(Model model){
        return "index";
    }

    @GetMapping("/add")
    public String add(@RequestParam String num1,
                      @RequestParam String num2,
                      Model model)
    {
        int intNum1 = Integer.parseInt( num1 );
        int intNum2 = Integer.parseInt( num2 );
        int result = calculator.add( intNum1, intNum2 );
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);
        return "index";
    }
    @GetMapping("/sub")
    public String sub(@RequestParam String num1,
                      @RequestParam String num2,
                      Model model)
    {
        int intNum1 = Integer.parseInt( num1 );
        int intNum2 = Integer.parseInt( num2 );
        int result = calculator.sub( intNum1, intNum2 );
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);
        return "index";
    }
    @GetMapping("/mul")
    public String mul(@RequestParam String num1,
                      @RequestParam String num2,
                      Model model)
    {
        int intNum1 = Integer.parseInt( num1 );
        int intNum2 = Integer.parseInt( num2 );
        int result = calculator.mul( intNum1, intNum2 );
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);
        return "index";
    }
    @GetMapping("/div")
    public String div(@RequestParam String num1,
                      @RequestParam String num2,
                      Model model)
    {
        int intNum1 = Integer.parseInt( num1 );
        int intNum2 = Integer.parseInt( num2 );
        double result = calculator.div( intNum1, intNum2 );
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);
        return "index";
    }

}
