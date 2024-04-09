package com.study.Pr03VM.dto;

import com.study.Pr03VM.entity.Product;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveProductDto {

    private Long id;
    private String name; // 상품명
    private int price; // 가격
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate limit_date; // 유통기한

    public Product toSaveEntity(){
        return Product.builder()
                .price(price)
                .limit_date(limit_date)
                .name(name)
                .build();
    }
    public Product toUpdateEntity(){
        return Product.builder()
                .id(id)
                .price(price)
                .limit_date(limit_date)
                .name(name)
                .build();
    }
}
