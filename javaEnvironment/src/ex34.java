class Book{
    int price = 1000;
    void read(){
        System.out.println("책을 읽는다");
    }

    public Book(){
        System.out.println("생성자 함수 호출");
    }
}
public class ex34 {
    public static void main(String[] args) {
        Book book = new Book();
    }
}
