
package com.study.Pr03VM.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.Pr03VM.entity.Product;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EditProductDto {
    private long id;
    private String inputName;
    private int inputPrice;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate inputLimitDate;

    public Product toUpdateEntity(){
        return Product.builder()
                .id(id)
                .price(inputPrice)
                .limit_date(inputLimitDate)
                .name(inputName)
                .build();
    }
}
