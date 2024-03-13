//상속 관계에서 생성자 호출되는 순서(초기화 순서)
class Energy{
    int price = 1000;
    Energy(){
        System.out.println("Energy 기본 생성자");
    }
    public Energy(int price){
        this.price=price;
        System.out.println("Energy 필드 생성자");
    }
}
class WindEnergy extends Energy{
    int price = 2000;
    WindEnergy(){
        System.out.println("wind 기본 생성자");
    }
    public WindEnergy(int price){
        //super은 반드시 첫 줄에 넣어야함. 첫 줄이 아니면 오류 발생!
        super(price); // 부모의 필드생성자 호출
        this.price=price;
        System.out.println("wind 필드 생성자");
    }
}

public class ex39 {
    public static void main(String[] args) {
        WindEnergy we1 = new WindEnergy();
        WindEnergy we2 = new WindEnergy(3000);
    }
}
