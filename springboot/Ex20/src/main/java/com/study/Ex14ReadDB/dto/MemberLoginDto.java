package com.study.Ex14ReadDB.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class MemberLoginDto {
    @NotBlank(message = "userId에 null, 빈문자열, 스페이스문자만 넣을 수 없습니다.")
    @Size(min=4,max=20)
    private String userId;

    @NotBlank(message = "userId에 null, 빈문자열, 스페이스문자만 넣을 수 없습니다.")
    @Size(min=4,max=20)
    private String userPw;
}