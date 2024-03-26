package com.study.Ex02SpringDI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//자바 빈을 생성하는 방법 2가지
//1. @Configration + @Bean
//2. @Component + @Autowired
//  1) 필드(field,멤버변수) 주입 : 일반적인 방법
//  2) 수정자(setter) 주입
//  3) 생성자(constructor) 주입 : 추천하는 방법

@SpringBootApplication
public class Ex02SpringDiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex02SpringDiApplication.class, args);
	}

}
