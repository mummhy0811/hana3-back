package com.study.Pr03VM.controller;

import com.study.Pr03VM.entity.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MainController {

    final ProductRepository productRepository;

    @GetMapping("/")
    public String main(){
        return "productList";
    }
    @GetMapping("/addProductForm")
    public String addProductForm(){
        return "addProductForm";
    }

    @GetMapping("/editProductForm")
    public String editProductForm(@RequestParam long id, Model model){
        model.addAttribute("product", productRepository.findById(id).get());

        return "editProductForm";
    }


}
