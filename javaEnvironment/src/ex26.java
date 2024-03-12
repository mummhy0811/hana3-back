class Cafe {
    int coffeeCount;
    Cafe(){
        coffeeCount=10;
    }
    public void sale(){
        this.coffeeCount--;
        System.out.println("커피를 판다");
    }
}
class Farm {
    int carrot;

    Farm(){
        carrot=0;
    }

    public void plant(){
        this.carrot++;
        System.out.println("당근을 1개 생산했습니다.");
    }
}

public class ex26 {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        for(int i=0;i<3;i++){
            cafe.sale();
        }
        System.out.println(cafe.coffeeCount);

        Farm farm = new Farm();
        for(int i=0;i<5;i++){
            farm.plant();
        }
        System.out.println(farm.carrot);
    }
}
