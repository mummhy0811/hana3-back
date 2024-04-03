package com.study.Pr03VM;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(){
        return "productList";
    }
    @GetMapping("/addProductForm")
    public String addProductForm(){
        return "addProductForm";
    }

    @GetMapping("/editProductForm")
    public String editProductForm(@RequestParam int index, Model model){
        model.addAttribute("index", index);
        model.addAttribute("product", RestAPIController.products.get(index));

        return "editProductForm";
    }


}
