//람다식

//코드를 변수처럼 전달하기 위해서
//자바: 객체(클래스-변수/함수), 람다식(비동기적 코드 처리)
//   : 선언되는 시점과 실행되는 시점이 다른 것
// 3세대 언어의 특징 - 함수형 언어(블럭형 언어)

@FunctionalInterface // 람다식 선언시에 사용
interface Myfunc1{
    int calc(int x, int y);
}
public class ex64 {
    public static void main(String[] args) {
        Myfunc1 f1 = (x, y) -> {return x+y;};
        f1.calc(1,2);
        exeFunc(f1);
    }
    static void exeFunc(Myfunc1 f1){ // 코드를 변수처럼 전달, 비동기적인 처리
        System.out.println(f1.calc(10, 20));
    }
}
