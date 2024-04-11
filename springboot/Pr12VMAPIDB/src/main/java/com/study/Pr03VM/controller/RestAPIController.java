package com.study.Pr03VM.controller;


import com.study.Pr03VM.dto.AddProductDto;
import com.study.Pr03VM.dto.EditProductDto;
import com.study.Pr03VM.dto.ResDto;
import com.study.Pr03VM.entity.Product;
import com.study.Pr03VM.entity.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RestAPIController {
    final ProductRepository productRepository;
    @GetMapping("/products")
    public List<Product> products(){
        return productRepository.findAll();
    }

    @DeleteMapping("/product")
    public ResDto deleteProduct(@RequestParam long id){
        productRepository.deleteById(id);

        return ResDto.builder()
                .status("ok").message("삭제되었습니다")
                .count(1).build();
    }
    @PutMapping("/product")
    public ResDto editProduct(@RequestBody EditProductDto dto) {

        productRepository.save(dto.toUpdateEntity());

        return ResDto.builder()
                .status("ok").message("수정되었습니다.")
                .count(1).build();
    }
    @PostMapping("/product")
    public ResDto addProduct(@RequestBody AddProductDto dto) {

        productRepository.save(dto.toSaveEntity());

        return ResDto.builder()
                .status("ok").message("추가되었습니다.")
                .count(1).build();
    }
}
