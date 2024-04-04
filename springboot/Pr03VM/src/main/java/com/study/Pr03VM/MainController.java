package com.study.Pr03VM;

import org.springframework.format.annotation.DateTimeFormat;
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
        model.addAttribute("count", products.size());
        return "productList";
    }

    @GetMapping("/addProductForm")
    public String addProductForm(){
        return "addProductForm";
    }

    @GetMapping("/editProductForm")
    public String editProductForm(@RequestParam int index, Model model){
        model.addAttribute("index", index);
        model.addAttribute("products", products.get(index));
        return "editProductForm";
    }

@PostMapping("/addProduct")
public String addProduct(@RequestParam String inputName, @RequestParam int inputPrice, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inputLimitDate){
    Product product = Product.builder()
            .name(inputName)
            .price(inputPrice)
            .limit_date(inputLimitDate)
            .build();

    products.add(product);

    return "redirect:/";
}

    @GetMapping("/deleteProduct")
    @ResponseBody
    public String deleteProduct(@RequestParam String index, Model model){

        products.remove( Integer.parseInt(index) );

        model.addAttribute("products", products);

        return "<script>alert('상품이 삭제되었습니다.'); location.href='/'; </script>\"";
    }
    @PostMapping("/editProduct")
    @ResponseBody
    public String editProduct(@RequestParam int index, @RequestParam String inputName, @RequestParam int inputPrice, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inputLimitDate){

        Product product = products.get(index);
        product.setName(inputName);
        product.setPrice(inputPrice);
        product.setLimit_date(inputLimitDate);

        products.set(index, product);

        return "<script>alert('상품이 수정되었습니다.'); location.href='/'; </script>\"";
    }
}
