//API : Application Programming Interface, 함수/클래스 호출의 접점.
//SDK : Softwear Development Kit, 소프트웨어 개발 툴 모음
//라이브러리 : Library 도서관. 함수나 클래스들의 모임.
//프레임워크 : Framework 뼈대. 어떤 소프트웨어를 만드는데 사용하는 근간. 모듈.
//콜렉션 : Collection. SW 모음.
//JDK : Java Development Kit. Java + SDK
//DLL : 동적 링크 라이브러리(dynamic-link library). 함수 및 클래스모임.
//JAR : Java Archive, 자바 아카이브. .class파일과 리소스(이미지,텍스트),
//      메타파일을 모아둔 것. 실행가능한 압축파일.
// 프레임워크 > 라이브러리 > 콜렉션 > SDK > API
public class ex51 {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        System.out.println(object1);
        System.out.println(object2);

        //hashCode: 객체 생성시 자동으로 부여되는 ID값
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());

        //string 관련 클래스
        //stringBuffer: 문자열을 좀 더 유연하게 제어하게 해줌
                        //추가(append), 삽입(insert), 삭제(delete)
        //stringBuilder: 대량의 문자열을 처리할 때 속도 향상. stringBuffer와 기능은 비슷함
        StringBuffer sb = new StringBuffer("init");
        System.out.println(sb);
        sb.append(" 123 ");
        System.out.println(sb);
        sb.insert(4, " abc");
        System.out.println(sb);
        sb.delete(2, 4);
        System.out.println(sb);

        StringBuilder sbuilder = new StringBuilder("init");
        System.out.println(sbuilder);
        sbuilder.append(" 123 ");
        System.out.println(sbuilder);
        sbuilder.insert(4, " abc");
        System.out.println(sbuilder);
        sbuilder.delete(2, 4);
        System.out.println(sbuilder);

    }
}
