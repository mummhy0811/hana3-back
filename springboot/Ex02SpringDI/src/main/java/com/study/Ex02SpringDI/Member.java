package com.study.Ex02SpringDI;

import org.springframework.stereotype.Component;

//스프링에서 빈 새성시 POJO클래스를 이용.
//POJO: 순수한 자바클래스. getter/setter/생성자만 추가해서 빈을 만든다.

@Component
public class Member {
    private String name="이순신";
    //기본생성자
    public Member(){}

    //매개변수가 있는 생성자
    public Member(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
