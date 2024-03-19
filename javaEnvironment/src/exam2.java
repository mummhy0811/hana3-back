import java.time.LocalDate;
import java.util.*;

public class exam2 {
    static class Book{
        private String name;
        private String publisher;
        private int price;
        private LocalDate pubDate;

        public Book(String name, String publisher, int price, LocalDate pubDate){
            this.name=name;
            this.publisher=publisher;
            this.price=price;
            this.pubDate=pubDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public LocalDate getPubDate() {
            return pubDate;
        }

        public void setPubDate(LocalDate pubDate) {
            this.pubDate = pubDate;
        }
    }
    static List<Book> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(true){
            System.out.println("-----도서 재고 관리 프로그램-----");
            System.out.print("1.입력 2.전체출력 3.정렬 4.수정: ");
            int target=sc.nextInt();
            if(target==1){ //입력
                System.out.print("책 이름 입력:");
                String book_name=sc.next();
                System.out.print("출판사 입력: ");
                String publish = sc.next();
                System.out.print("출판일 입력: ");
                String date=sc.next();
                LocalDate publish_Date = LocalDate.parse(date);
                System.out.print("가격 입력: ");
                int price = sc.nextInt();
                list.add(new Book(book_name, publish,price,publish_Date));
                System.out.println("도서가 입고되었습니다.");
                printNum();
            }else if(target==2){ //전체 출력
                for(int i=0;i<list.size();i++){
                    printInfo(i);
                }
                printNum();
            }else if(target==3){ //정렬
                System.out.println("책 이름 가나다순(1) 출판일 최근순(2)");
                System.out.print("정렬 기준: ");
                int sort=sc.nextInt();
                if(sort==1){
                    List<String> sortedBook = new LinkedList<>();
                    for(int i=0;i<list.size();i++){
                        sortedBook.add(list.get(0).getName());
                    }
                    Collections.sort(sortedBook);
                    for(int i=0;i<sortedBook.size();i++){
                        for(int j=0;j<list.size();j++){
                            if(sortedBook.get(i).equals(list.get(j).getName())){
                                System.out.print(i+1+".");
                                printInfo(i);
                                break;
                            }
                        }
                    }
                }else if(sort==2){
                    List<LocalDate> sortedBook = new LinkedList<>();
                    for(int i=0;i<list.size();i++){
                        sortedBook.add(list.get(0).getPubDate());
                    }
                    Collections.sort(sortedBook);
                    for(int i=0;i<sortedBook.size();i++){
                        for(int j=0;j<list.size();j++){
                            if(sortedBook.get(i).equals(list.get(j).getPubDate())){
                                System.out.print(i+1+".");
                                printInfo(i);
                                break;
                            }
                        }
                    }
                }else {
                    System.out.println("잘못된 입력입니다.");
                }
                printNum();
            }else if(target==4){ //수정
                System.out.print("수정할 책이름 입력: ");
                String name=sc.next();
                System.out.println("출판사 입력:");
                String publish = sc.next();
                System.out.print("출판일 입력: ");
                String date=sc.next();
                LocalDate publish_Date = LocalDate.parse(date);
                System.out.print("가격 입력: ");
                int price = sc.nextInt();
                for (Book value : list) {
                    if (value.getName().equals(name)) {
                        value.setPrice(price);
                        value.setPublisher(publish);
                        value.setPubDate(publish_Date);
                        break;
                    }
                }
                System.out.println("도서정보가 수정되었습니다.");
            }else{
                System.out.println("잘못된 입력입니다.");
            }

        }
    }
    public static void printInfo(int targetIndex){
        Book book = list.get(targetIndex);
        System.out.print(book.getName()+"/"+book.getPublisher()+"/"+book.getPubDate()+"/"+book.getPrice()+"\n");
    }
    public static void printNum(){
        System.out.printf("총 도서의 수는 %d권 입니다.\n",list.size());
    }
}
