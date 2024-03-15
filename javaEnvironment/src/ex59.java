class Printer extends Thread{
    int count=0;
    @Override
    public void run() {
//        super.run(); //지워야함 이거 있으면 수행 안됨
        //thread가 생성되면 딱 한 번만 실행됨. 계속 살아있게 하고 싶으면 무한반복 사용.
        while(true){
            System.out.println("printer: "+count++);
        }
    }
}

class Printer2 implements Runnable{
    int count=0;

    @Override
    public void run() {

    }
}
public class ex59 {
    public static void main(String[] args) {
        //스레드: Thread 실타래: 프로그램 안의 작은 프로그램을 의미

        //스레드 구현 방법
        //Thread 추상클래스 이용
        //Runnable 인터페이스 이용

        Printer printer = new Printer();
        printer.start();
        System.out.println("메인 스레드 종료");
    }
}
