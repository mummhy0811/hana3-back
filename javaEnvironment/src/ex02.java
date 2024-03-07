public class ex02 {
    public static void main(String[] args) {
        //한 줄 주석문
        /*
        여러줄 주석문
         */

        System.out.println("화면출력");
        System.out.println("화면"+"출력");
        System.out.println("화면"+10+20); //화면1020
        System.out.println(10+20+"화면"); //30화면
        System.out.println(10+(20+"화면")); //1020화면 - 소괄호가 먼저 수행

        System.out.println("줄바꿈");
        System.out.print("줄바꿈x");
        //\n:줄바꿈 특수문자
        System.out.printf("%d\n", 30); //10진수
        System.out.printf("%o\n", 30); //8진수
        System.out.printf("%x\n", 30); //16진수
        System.out.printf("%e\n", 300.0); // 3.000000e+02 - 지수형 출력

        // 연습문제 DM으로 스샷을 보내주세요
        // 다음과 같이 출력하시오.
        // 1. "Coding is Good!"
        System.out.println("Coding is Good!");
        // 2. "Java"문자와 "Programming"문자를  +연결연산자로 연결해서 출력하시오.
        System.out.println("Java"+"Programming");
        // 3. 십진 정수 123을 printf를 이용하여 출력하시오.
        System.out.printf("%d\n", 123);
        // 4. 십진 정수 123을 printf를 이용하여 "00123"으로 출력하시오.
        System.out.printf("%05d\n", 123);
        // 5. 실수형 123.45f를 printf를 이용하여 "123.450"로 출력하시오.
        System.out.printf("%.3f\n", 123.45);
    }
}
