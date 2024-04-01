package com.study.Ex12H2DB;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository: 스프링 JPA라이브러리에서 엔티티에 대한 기본적인 조회, 삽입, 수정, 삭제가 가능하도록 만든 인터페이스
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //JpaRepository의 기본함수
    //findAll()
    //findBy열이름()
    //save()
    //delete()
}
