public class ex31 {
    static void echo() {
        System.out.println("echo");
    }

    static void echo(int x) {
        System.out.println("echo: " + x);
    }

    //연습문제 - 오버로딩 연습
    // 메소드(함수) 이름 : calc
    // 반환형은 없음.
    //1. 매개변수 정수형 1개일때는 그냥 변수값만 출력
    //2. 매개변수 정수형 2개일때는 두 변수의 합계를 출력
    //3. 매개변수 정수형 3개일때는 세 변수중에서
    //   최대값을 출력하시오.

    static void calc(int a) {
        System.out.println(a);
    }

    static void calc(int a, int b) {
        System.out.println(a + b);
    }

    static void calc(int a, int b, int c) {
        int max = Math.max(a, b);
        max = Math.max(max, c);
        System.out.println(max);
    }

    public static void main(String[] args) {
        //함수 오버로딩
        calc(1);
        calc(1, 2);
        calc(1, 2, 3);
    }
}
