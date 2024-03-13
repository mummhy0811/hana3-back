class Robot{
    String color="빨강";
    int price=1000;
    public Robot(){
        System.out.println("기본 생성자 함수");
    }
    public Robot(String color){
        this.color = color;
        System.out.println("필드가 있는 생성자 함수");
    }
    public Robot(String color, int price){
        this.color = color;
        this.price=price;
        System.out.println("필드가 있는 생성자 함수");
    }
}
public class ex38 {
    public static void main(String[] args) {

    }
}
