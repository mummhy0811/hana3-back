package com.study.Ex14ReadDB.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    @Query(value = "select * from member m where m.user_id = :param_user_id " +
            "and m.user_pw = :param_user_pw", nativeQuery = true)
    Optional<MemberEntity> findByUserIdAndUserPw(
            @Param("param_user_id") String userId,
            @Param("param_user_pw") String userPw);

    @Query(value = "select * from member m where m.user_id = :userId",
            nativeQuery = true)
    Optional<MemberEntity> findByUserId(String userId);

}
