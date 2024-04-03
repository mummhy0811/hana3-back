package com.study.Pr03VM;


import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestAPIController {
    static List<Product> products = new ArrayList<>();
    public RestAPIController(){
        Product product = Product.builder().name("소고기버거").price(2000).limit_date(LocalDate.parse("2024-01-01")).build();
        Product product2 = Product.builder().name("토마토버거").price(3000).limit_date(LocalDate.parse("2024-02-01")).build();
        Product product3 = Product.builder().name("배추버거").price(4000).limit_date(LocalDate.parse("2024-03-01")).build();

        products.add(product);
        products.add(product2);
        products.add(product3);
    }
    @GetMapping("/products")
    public List<Product> products(){
        return products;
    }

    @DeleteMapping("/product")
    public ResDto deleteProduct(@RequestParam int index){
        products.remove(index);

        return ResDto.builder()
                .status("ok").message("삭제되었습니다")
                .count(1).build();
    }
    @PutMapping("/product")
    public ResDto editProduct(@RequestBody EditProductDto dto) {
        System.out.println(dto.getInputName());
        int index = dto.getIndex();

        Product product = Product.builder()
                .name(dto.getInputName())
                .price(dto.getInputPrice())
                .limit_date(dto.getInputLimitDate())
                .build();
        products.set( index, product);

        return ResDto.builder()
                .status("ok").message("수정되었습니다.")
                .count(1).build();
    }
    @PostMapping("/product")
    public ResDto addProduct(@RequestBody AddProductDto dto) {

        Product product = Product.builder()
                .name(dto.getInputName())
                .price(dto.getInputPrice())
                .limit_date(dto.getInputLimitDate())
                .build();
        products.add( product );

        return ResDto.builder()
                .status("ok").message("추가되었습니다.")
                .count(1).build();
    }
}
