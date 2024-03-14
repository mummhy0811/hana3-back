//익명 객체
interface NormalCar{
    void run();
}
//정식적인 방법(여러번 사용시)
class SuperCar implements NormalCar{
    @Override
    public void run() {
        System.out.println("슈퍼카가 달린다");
    }
}
public class ex49 {
    public static void main(String[] args) {
        SuperCar superCar = new SuperCar();
        superCar.run();
        //일회성 익명 인터페이스 구현 객체를 선언/생성
        NormalCar normalCar = new NormalCar() {
            @Override
            public void run() {
                System.out.println("슈퍼카가 달린다.");
            }
        };
        normalCar.run();


    }
}
