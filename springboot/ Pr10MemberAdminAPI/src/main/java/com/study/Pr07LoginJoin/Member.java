package com.study.Pr07LoginJoin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String name;
    private String email;
    private String password;
    private LocalDate joindate;
}