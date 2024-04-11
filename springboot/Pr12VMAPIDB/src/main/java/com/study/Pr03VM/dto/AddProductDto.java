
package com.study.Pr03VM.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.Pr03VM.entity.Product;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddProductDto {
    private String inputName;
    private int inputPrice;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate inputLimitDate;

    public Product toSaveEntity(){
        return Product.builder()
                .price(inputPrice)
                .limit_date(inputLimitDate)
                .name(inputName)
                .build();
    }
}
