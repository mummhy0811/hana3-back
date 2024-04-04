package com.study.Ex12H2DB;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity //DB 테이블과 1:1로 매칭되는 JPA 클래스에 사용
@Table(name="member") //테이블명 지정. 기본 테이블 이름은 클래스 이름
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GeneratedValue: 해당 ID값을 어떻게 생성할지 전략 선택
                                                        //1. IDENTIFY: MySQL, MariaDB, PostreSQL, H2
                                                        //2. SEQUENCE: Oracle, PostreSQL
                                                        //3. AUTO: 자동으로 선택
    @Column //DB열과 매칭(변수 이름과 DB 컬럼 이름이 다를 때.)
    private Long id;
    @Column
    private String userId;
    @Column
    private String userPw;
    @Column
    private String userName;
    @Column
    private String userRole;
    @Column
    @DateTimeFormat(pattern = "yyyy-mm-dd") //DB테이터를 가져올 때 형식화 해줌
    private LocalDate joindate;

    public void update(String userId, String userPw, String userName,
                       String userRole){
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userRole = userRole;
    }
}
