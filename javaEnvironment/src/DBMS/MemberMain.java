package DBMS;

import java.util.List;

public class MemberMain {
    public static void main(String[] args) {
        //dao 객체 생성
        MemberDAO dao = new MemberDAO();


        MemberVO vo = new MemberVO();
//        vo.setMemberno();
        vo.setId("min");
        vo.setName("김민재");

        int result = dao.insert(vo);
        if(result>0) System.out.println("회원 등록 성공");
        else System.out.println("회원 등록 실패");

        List<MemberVO> list = dao.list();
        for(MemberVO member:list){
            System.out.println("회원번호: "+ member.getMemberno());
        }

        //자원 해제
        dao.close();
    }
}