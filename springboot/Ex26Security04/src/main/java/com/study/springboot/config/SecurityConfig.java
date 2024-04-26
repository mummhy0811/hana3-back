package com.study.springboot.config;

import com.study.springboot.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity  //웹보안 활성화를 위한 Annotation
@RequiredArgsConstructor
public class SecurityConfig {
    final private CustomOAuth2UserService customOAuth2UserService;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf((auth)->auth.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .authorizeHttpRequests( (auth) -> auth
                        .requestMatchers(
                                new AntPathRequestMatcher("/"),
                                new AntPathRequestMatcher("/joinForm"),
                                new AntPathRequestMatcher("/joinAction")
                        ).permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated() //그외 어떤 요청에도 인증을 한다.
                )

                //로그인 인증에 대한 설정을 시작
                .formLogin((formLogin) -> formLogin
                        .loginPage("/loginForm")
                        .loginProcessingUrl("/loginAction")
                        .defaultSuccessUrl("/")
                        .successHandler(((request, response, authentication) -> {
                            response.sendRedirect("/");
                        }))
                        //실패시 에러페이지
                        .failureUrl("/loginForm?error")
                        .permitAll())
                //로그아웃 처리
                .logout((auth) -> auth
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logoutAction"))
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true) //세션 객체을 해제(내부 저장 데이터도 소멸)
                        .deleteCookies("JSESSIONID") //reponse 헤더에 Set Cookie에 ""을 넣어준다.
                )
                //SNS 로그인
                .oauth2Login( oauth2 -> oauth2
                        .userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig
                                .userService(customOAuth2UserService))
                        .successHandler(successHandler())
                        .failureHandler(failureHandler())
                );
        return http.build();
    }
    @Bean
    SimpleUrlAuthenticationSuccessHandler successHandler(){
        return new SimpleUrlAuthenticationSuccessHandler("/snsLoginSuccess");
    }
    @Bean
    SimpleUrlAuthenticationFailureHandler failureHandler(){
        return new SimpleUrlAuthenticationFailureHandler("/snsLoginFailuer");
    }
    //BCrypt 암호화 엔코더 빈 생성
    @Bean
    public PasswordEncoder passwordEncoder(){
        //Spring Security 5.3.3에서 공식 지원하는 PasswordEncoder 구현 클래스들은 아래와 같습니다.
        //BcryptPasswordEncoder : BCrypt 해시 함수를 사용해 비밀번호를 암호화
        //Argon2PasswordEncoder : Argon2 해시 함수를 사용해 비밀번호를 암호화
        //Pbkdf2PasswordEncoder : PBKDF2 해시 함수를 사용해 비밀번호를 암호화
        //SCryptPasswordEncoder : SCrypt 해시 함수를 사용해 비밀번호를 암호화

        //강도는 4 ~ 31까지 설정할 수 있으며, 기본강도 10이다.
        return new BCryptPasswordEncoder( 16 );
        //return SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
        //return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        //return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

}