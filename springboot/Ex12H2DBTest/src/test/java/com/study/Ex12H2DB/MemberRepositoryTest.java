package com.study.Ex12H2DB;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest extends Ex12H2DbApplicationTests{
    //테스트 클래스에서는 생성자 주입 안됨.
    @Autowired
    MemberRepository memberRepository;

    @BeforeAll  //static 메소드
    static void setup(){
        System.out.println("@BeforeAll - 클래스를 초기화시 한번 수행");

    }
    @BeforeEach //non-static 메소드
    void init(){
        System.out.println("@BeforeEach - @Test 메소드를 호출시마다 한번 수행");
        save();
    }
    @Test //테스트할 메소드에 사용
    @DisplayName("save 테스트") //콘솔에 출력되는 메소드 이름
    public void save(){
//        memberRepository.save(new MemberEntity(1L, "hong", "1234", "홍길동", "ROLE_USER", LocalDate.now()));
//        memberRepository.save(new MemberEntity(2L, "tom", "1234", "톰아저씨", "ROLE_USER", LocalDate.now()));
//        memberRepository.save(new MemberEntity(3L, "admin", "1234", "관리자", "ROLE_ADMIN", LocalDate.now()));
        memberRepository.save(new MemberEntity(Long.valueOf(1),
                "hong", "1234", "홍길동", "ROLE_USER", LocalDate.parse("2023-01-01")
        ));
        memberRepository.save(new MemberEntity(Long.valueOf(2),
                "tom", "1234", "톰아저씨", "ROLE_USER", LocalDate.parse("2023-02-01")
        ));
        memberRepository.save(new MemberEntity(Long.valueOf(3),
                "admin", "1234", "관리자", "ROLE_ADMIN", LocalDate.parse("2023-03-01")
        ));
        List<MemberEntity> list = memberRepository.findAll();
        assertEquals( 3, list.size() );
    }
    @Test
    @DisplayName("findById 테스트")
    public void findById(){
        //Optional 클래스 : JDK 9부터 제공. null safety를 제공한다.
        Optional<MemberEntity> member = memberRepository.findById( 1L );
        member.ifPresentOrElse((unwrappedMemberEntity) -> {
            // null이 아닐 때 수행되는 람다식
            System.out.println(unwrappedMemberEntity.getUserName());
            assertEquals("홍길동", unwrappedMemberEntity.getUserName());
        }, () -> fail("member 엔티티가 null입니다."));

    }
    @Test
    @DisplayName("count 테스트")
    public void count(){
        Long count = memberRepository.count();
        System.out.println("count : " + count );
        assertEquals( 3, count);
    }

    @Test
    @DisplayName("쿼리메소드 테스트")
    public void query(){
        List<MemberEntity> list = memberRepository.findByUserId("tom");
        assertEquals(1,list.size());
        assertEquals("톰아저씨", list.get(0).getUserName());

        List<MemberEntity> list2 = memberRepository.findFirst5ByUserIdAndUserNameOrderByIdDesc("hong", "홍길동");
        assertEquals(1, list2.size());

    }

    @Test
    @DisplayName("JPQL 테스트")
    public void jpqlQuery(){
        List<MemberEntity> list = memberRepository.findByUserId_JPQL_Query("tom");
        assertEquals(1, list.size());
    }
    @Test
    @DisplayName("NativeQuery 테스트")
    public void nativeQuery(){
        List<MemberEntity> list = memberRepository.findByUserId_nativeQuery("admin");
        assertEquals(1, list.size());
        assertEquals("관리자", list.get(0).getUserName());
    }
    @Test
    @DisplayName("update 테스트")
    public void update(){
        Optional<MemberEntity> member=memberRepository.findById(1L);
        member.ifPresentOrElse((newMember)->{
            assertEquals("hong", newMember.getUserId());
            newMember.update("hong2", newMember.getUserPw(), newMember.getUserName(), newMember.getUserRole());
            memberRepository.save(newMember);
            findById();
        }, ()->{
            fail("member 엔티티가 null입니다");
        });

    }

    //member 테이블 안에 암호가 "1234"인 회원이 있는지 테스트 하시오.
    @Test
    @DisplayName("암호 1234")
    public void findPw1234(){
        List<MemberEntity> member = memberRepository.findByUserPw("1234");
        assert(!member.isEmpty());
    }

    //23년도 3월에 가입한 회원의 수가 1인지 테스트하시오.
    @Test
    @DisplayName("202303 회원가입")
    public void findJoinDate(){
        List<MemberEntity> members = memberRepository.findAllByJoindateBetween(LocalDate.parse("2023-03-01"),LocalDate.parse("2023-03-31"));
        assertEquals(1, members.size());
    }

    //"lee"라는 아이디로 회원가입하고자 할때, 아이디 중복인지 테스트하시오.
    @Test
    @DisplayName("아이디 중복 테스트")
    public void checkDuplicate(){
        List<MemberEntity> members = memberRepository.findByUserId("lee");
        assert(members.isEmpty());
    }


    //"tom"이라는 아이디의 회원정보를 수정하고, 잘 수정되었는지 테스트하시오.
//    톰아저씨 -> 마이클, 암호 -> 3456
    @Test
    @DisplayName("회원정보 수정")
    public void checkUpdate(){
        List<MemberEntity> members=memberRepository.findByUserId("tom");
        assert(!members.isEmpty());
        MemberEntity member = members.get(0);
        members.get(0).update(member.getUserId(), "3456", "마이클",member.getUserRole());

        List<MemberEntity> members2=memberRepository.findByUserId("tom");
        assert(!members2.isEmpty());
        MemberEntity updatedMember = members.get(0);
        assertEquals(updatedMember.getUserName(),"마이클");
        assertEquals(updatedMember.getUserPw(),"3456");
    }
}