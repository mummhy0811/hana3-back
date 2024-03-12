class BallFactory{
    int ballCount=100;
    void make(){
        this.ballCount++;
        System.out.println("축구공 생산!");
    }
}

class FoodFactory{
    static int foodCount=200;
    static void make(){
        foodCount++;

    }
}
public class ex27 {
    public static void main(String[] args) {
        BallFactory ballFactory=new BallFactory();
        System.out.println(ballFactory.ballCount);
        //static 변수, 함수는 클래스 이름 뒤에 점을 찍어서 접근
        System.out.println(FoodFactory.foodCount);
    }
}
