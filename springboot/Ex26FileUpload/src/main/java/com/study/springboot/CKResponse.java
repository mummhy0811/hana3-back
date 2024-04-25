package com.study.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CKResponse {
    private Integer uploaded;
    private String fileName;
    private String url;
}
