package DBMS;

//데이타를 담는 클래스 종류
//VO : View Object, 값의 수정이 안되고, 로직이 없음.
//DTO : Data Transfer Object, 레이어간 데이타 전송 용도.
//ENTITY : DB 컬럼과 1:1로 연결됨. Spring JPA에서 주로 사용.

//데이타의 조작을 하는 클래스
//DAO : Data Acess Object, DB 조작 메소드들의 집합, CURD 메소드들.

public class MemberVO {
    //DB 컬럼과 1:1 매칭
    // INT : int (Integer)
    // VARCHAR : String
    // DATE : LocalDate
    // DATETIME : LocalDateTime
    private int memberno;//회원번호
    private String id;//아이디
    private String name;//이름

    public int getMemberno() {
        return memberno;
    }

    public void setMemberno(int memberno) {
        this.memberno = memberno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}