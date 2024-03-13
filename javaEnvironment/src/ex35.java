class StaticClass{
    int a;
    static int b=0;
    static{ // 프로그램 시작시 호출됨. main함수 이전에
        b=5;
        System.out.println("static block!");
    }
    //생성자 함수
    StaticClass(){
        a=3;
        b=10;
    }
}

public class ex35 {
    public static void main(String[] args) {
        System.out.println(StaticClass.b);
        StaticClass s = new StaticClass();
        System.out.println(StaticClass.b);
    }
}
