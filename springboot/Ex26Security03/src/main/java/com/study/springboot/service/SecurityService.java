package com.study.springboot.service;

import com.study.springboot.entity.MemberEntity;
import com.study.springboot.entity.MemberRepository;
import com.study.springboot.enumeration.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {
    private final MemberRepository memberRepository;

    //사용자 아이디를 통해 사용자 정보와 권한을 시큐리티에 전달
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MemberEntity> optional = this.memberRepository.findByUserId(username);
        if(optional.isEmpty()){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        MemberEntity memberEntity = optional.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(username.equals("admin")){
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        }else{
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }
        return new User(memberEntity.getUsername(), memberEntity.getPassword(), authorities);
    }
}
