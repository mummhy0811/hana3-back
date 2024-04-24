package com.study.springboot;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService implements UserDetailsService {
    //사용자 아이디를 통해 사용자 정보와 권한을 시큐리티에 전달

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        //테스트용 admin => hong, 1234
        authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        //암호는 문자열 그대로 보내는 것이 아니라, 암호화해서 보낸다.(bcrypt)


        return new User("hong", "$2a$12$kZag3Zw1W5PaxMGYtNKyFe2uYjlOpdVo2nr4dNK1UjSJJCfTyNf6S", authorities);
    }
}
