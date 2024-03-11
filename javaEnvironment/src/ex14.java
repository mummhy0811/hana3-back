public class ex14 {
    public static void main(String[] args) {
        //조건문 연습문제
        //철수와 영희가 주사위 놀이를 하고 있다.
        // 주사위 2개를 던져서,
        // 두개 다 짝수가 나오면 철수 승!
        // 두개 다 홀수가 나오면, 영희 승!
        // 그외의 경우는 무승부! 이다.
        // 게임의 결과를 출력하시오.
        int num1 = (int) ((Math.random() * 10000) % 6);
        int num2 = (int) ((Math.random() * 10000) % 6);
        if (num1 % 2 == 0 && num2 % 2 == 0) {
            System.out.println("철수 승!");
        } else if (num1 % 2 != 0 && num2 % 2 != 0) {
            System.out.println("영희 승!");
        } else {
            System.out.println("무승부");
        }
    }
}
