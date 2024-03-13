class ClassM{
    int price=10;
}

interface Vehicle{
    public void drive(); //추상메소드(가상함수)
    public default void run(){ //default 이용해 일반 함수 작성
        System.out.println("달린다");
    }
}
//인터페이스 상속을 통한 확장
interface Truck extends Vehicle{

}
class Tesla implements Vehicle{
    @Override
    public void drive() {

    }

}
public class ex48 {
    public static void main(String[] args) {
        Tesla tesla = new Tesla();
        tesla.run();
        tesla.drive();
    }
}
