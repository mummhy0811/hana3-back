package com.study.Ex12H2DB;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.*;

//JpaRepository: 스프링 JPA라이브러리에서 엔티티에 대한 기본적인 조회, 삽입, 수정, 삭제가 가능하도록 만든 인터페이스
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    List<MemberEntity> findByUserId(String userId);

    // And, Or을 메소드 이름에 추가할 수 있음
    // OrderBy 필드이름 Desc, Asc
    List<MemberEntity> findFirst5ByUserIdAndUserNameOrderByIdDesc(String userId, String userName);
    Boolean existsByJoindateLessThanEqual(LocalDate date);
    long countByUserNameIgnoreCaseLike(String userid);

    //JPA에서 SQL사용
    // 1.JPQL
    // - 표준 ANSI SQL문법 지원
    // - 특정 DB에 종속적인 기능은 지원X
    // - from절 뒤에는 엔티티 클래스 이름을 넣어줌(소문자로 하면 에러)
    @Query(value = "Select m from MemberEntity m Where m.userId= :userId")
    List<MemberEntity> findByUserId_JPQL_Query(String userId);

    //2. Native SQL
    //- 특정 DB에 종속적인 기능 제공
    // ex) MySQL: LIMIT5, now(), AUTO_INCREMENT
    // Oracle: sysdate, 시퀀스
    // Update, Insert, Delete문은 @Modifying, @Transactional 추가 필요
    @Query(value="SELECT * FROM member WHERE user_id= :userid", nativeQuery = true)
    List<MemberEntity> findByUserId_nativeQuery(String userid);

    @Modifying
    @Transactional
    @Query(value="Update member set user_id=:userid where id=:id", nativeQuery = true)
    int updateById_nativeQuery(Long id);


    //연습문제
    List<MemberEntity> findByUserPw(String userPw);

    List<MemberEntity> findAllByJoindateBetween(LocalDate date,LocalDate date2);
}
