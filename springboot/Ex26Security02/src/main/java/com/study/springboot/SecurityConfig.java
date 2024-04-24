package com.study.springboot;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity  //웹보안 활성화를 위한 Annotation
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //csrf 보안을 쿠키방식으로 지정한다.
                .csrf((auth)->auth.disable()) //csrf보안 비활성화
                                            //NOTE csrf보안 비활성화 이유(기본은 활성화)
                            //                rest api를 이용한 서버라면, session 기반 인증과는 다르게 stateless하기 때문에 서버에 인증정보를 보관하지 않는다.
                            //                rest api에서 client는 권한이 필요한 요청을 하기 위해서는 요청에 필요한 인증 정보를(OAuth2, jwt토큰 등)을 포함시켜야 한다.
                            //                따라서 서버에 인증정보를 저장하지 않기 때문에 굳이 불필요한 csrf 코드들을 작성할 필요가 없다.
                .csrf((auth)->auth.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                            //                CsrfTokenRepository 인터페이스는 HttpSessionCsrfTokenRepository,CookieCsrfTokenRepository 2개가 있다.
                            //                기본적으로 스프링 시큐리티는 HttpSessionCsrfTokenRepository로 CSRF 토큰을 HttpSession에 저장한다.
                            //                하지만 커스텀 CsrfTokenRepository를 설정하고 싶을 때도 있을 것이다.
                            //                예를 들어 자바스크립트 기반 어플리케이션을 지원하려면 쿠키에 CsrfToken을 저장해야 한다.
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/admin").hasRole("ADMIN") //관리자 페이지 ADMIN 인증 요청
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER") //my페이지는 로그인 인증 요청
                        .anyRequest().authenticated() //그 외 어떤 요청에서도 인증 요청
                )
                //로그인 인증에 대한 설정을 시작
                .formLogin((formLogin) -> formLogin //로그인 페이지를 /loginForm URI로 하겠다.
                        .loginPage("/loginForm") //로그인 성공시 넘어가 URI를 지정한다.
                        .loginProcessingUrl("/loginAction")
                        .defaultSuccessUrl("/")
                        .successHandler((((request, response, authentication) -> { //인증 성공 후 별도의 처리가 필요한 경우 커스텀 핸들러 생성/동록
                            System.out.println("로그인 성공");
                            response.sendRedirect(("/"));
                        })))
                        .failureForwardUrl("loginForm?error") // 실패시 에러
                        .permitAll()
                        )
                //로그아웃 처리
                .logout((auth)->auth.logoutRequestMatcher(new AntPathRequestMatcher("logoutAction"))
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)//세션 객체 해제
                        .deleteCookies("JSESSIONID") //response 헤더의 Set Cookie에 ""삽입
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        //Spring Security 5.3.3에서 공식 지원하는 PasswordEncoder 구현 클래스들은 아래와 같습니다.
        //BcryptPasswordEncoder : BCrypt 해시 함수를 사용해 비밀번호를 암호화
        //Argon2PasswordEncoder : Argon2 해시 함수를 사용해 비밀번호를 암호화
        //Pbkdf2PasswordEncoder : PBKDF2 해시 함수를 사용해 비밀번호를 암호화
        //SCryptPasswordEncoder : SCrypt 해시 함수를 사용해 비밀번호를 암호화


        //강도는 4~31까지, 기본은 10
        return new BCryptPasswordEncoder(12);
    }
}
