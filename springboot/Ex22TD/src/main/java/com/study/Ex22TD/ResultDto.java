package com.study.Ex22TD;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {
    private String status;
    private String message;
}
