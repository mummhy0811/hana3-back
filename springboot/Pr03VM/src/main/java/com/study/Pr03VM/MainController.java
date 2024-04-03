package com.study.Pr03VM;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    static List<Product> products = new ArrayList<>();

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("products", products);
        return "productList";
    }

    @GetMapping("/addProductForm")
    public String addProductForm(){
        return "addProductForm";
    }

    @GetMapping("/editProductForm")
    public String editProductForm(){
        return "editProductForm";
    }

    @PostMapping("/addProduct")
    @ResponseBody
    public String add(@RequestParam String name, @RequestParam int price, @RequestParam LocalDate limitDate){

        Product product = Product.builder()
                .name(name)
                .price(price)
                .limit_date(limitDate)
                .build();

        products.add(product);

        return "<script>alert('상품이 추가되었습니다.'); location.href='/'; </script>";
    }

    @GetMapping("/deleteProduct")
    public String delete(@RequestParam String index, Model model){

        products.remove( Integer.parseInt(index) );

        model.addAttribute("products", products);

        return "admin";
    }
}
