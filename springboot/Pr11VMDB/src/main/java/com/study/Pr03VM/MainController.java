package com.study.Pr03VM;

import com.study.Pr03VM.dto.SaveProductDto;
import com.study.Pr03VM.entity.Product;
import com.study.Pr03VM.entity.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ProductRepository productRepository;

    @GetMapping("/")
    public String main(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("count", products.size());
        return "productList";
    }

    @GetMapping("/addProductForm")
    public String addProductForm(){
        return "addProductForm";
    }

    @GetMapping("/editProductForm")
    public String editProductForm(@RequestParam long id, Model model){
        System.out.println(id);
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent()){
            model.addAttribute("id", id);
            model.addAttribute("products",optional.get());
            return "editProductForm";
        }
        System.out.println("정보가 없습니다");
        return "redirect:/";
    }

@PostMapping("/addProduct")
@ResponseBody
public String addProduct(@ModelAttribute SaveProductDto dto){

        try{
            Product product = dto.toSaveEntity();
            productRepository.save(product);
        }catch (Exception e){
            return "<script>alert('상품 추가 실패'); history.back();</script>";
        }

    return "<script>alert('상품 추가 완료'); location.href='/';</script>";
}

    @GetMapping("/deleteProduct")
    @ResponseBody
    public String deleteProduct(@RequestParam long id){
        productRepository.deleteById(id);

        return "<script>alert('상품이 삭제되었습니다.'); location.href='/'; </script>\"";
    }
    @PostMapping("/editProduct")
    @ResponseBody
    public String editProduct(@ModelAttribute SaveProductDto dto){

        Product product = dto.toUpdateEntity();
        productRepository.save(product);

        return "<script>alert('상품이 수정되었습니다.'); location.href='/'; </script>\"";
    }
}
