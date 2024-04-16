package com.study.Ex22TD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    Member member;

    public int loginAction(Member member){
        if(member.getLoginId().equals("hong") && member.getLoginPw().equals("1234")){
            return 1;
        }
        return 0;
    }
}
