package com.study.Ex01FirstApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//@SpringBootApplication : 3가지의 어노테이션을 합쳐논 것
//  : 기본적인 스프링부트 앱 개발환경과 설정을 다 해준다.
//1. @ComponentScan : @Component가 붙은 클래스를 찾아서 Bean으로 등록한다.
//2. @EnableAutoConfiguration : 스프링 프레임워크의 기본적인 기능을 활성화할 때
//                              사용하는 어노테이션이다.
//3. @SpringBootConfiguration : @Configuration이 붙은 클래스를 스프링 프레임워크의
//                              설정 클래스로 등록한다.

//@Bean와 @Component의 차이
//1.@Bean은 Config클래스 안에서 사용되고, 주로 외부 라이브러리 사용시(개발자 제어불가) 사용.
//2.@Component는 주로 개발자가 직접 작성한 클래스에 사용.
@Configuration
class MyConfig{ //웹 어플리케이션의 설정 정보를 담는 클래스
	@Bean
	public Student student(){
		System.out.println("bean generated!");
		return new Student();
	}
}
class Student{
	String name="Hong";
}
@SpringBootApplication
public class Ex01FirstAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex01FirstAppApplication.class, args);
		System.out.println("start spring boot!!");
		//스프링 컨테이너에 등록된 빈(객체)를 사용
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		Student obj = (Student) context.getBean("student");
		System.out.println(obj.name);
	}

}
