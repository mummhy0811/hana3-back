package com.study.Ex14ReadDB.entity;

import com.study.Ex14ReadDB.dto.MemberSaveDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "member")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_pw")
    private String userPw;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_role")
    private String userRole;
    @Column(name = "join_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;


    public MemberSaveDto toSaveDto() {
        return MemberSaveDto.builder()
                .id(id)
                .userId(userId)
                .joinDate(joinDate)
                .userName(userName)
                .userPw(userPw)
                .userRole(userRole)
                .build();
    }
}