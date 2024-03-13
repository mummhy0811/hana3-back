import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student{
    String name;
    int kor;
    int eng;
    int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

}
public class mini03 {
    public static Scanner sc = new Scanner(System.in); // Scanner 객체 생성
    public static List<Student> list = new ArrayList<>();
    public static void main(String[] args) {

        while(true){
            System.out.println("-----------성적 관리 프로그램-------------");
            System.out.print("1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 :");
            int num = sc.nextInt();
            switch(num){
                case 1:
                    add();
                    break;
                case 2:
                    printAll();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    edit();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    System.out.println("종료!!");
                    return;
            }

        }
        //ArrayList 관련 함수들 : 전체지우기, 추가, 삭제, 검색(직접 코드로)

    }
    public static void add(){
        System.out.print("이름 입력: ");
        String name = sc.next();
        System.out.print("국어점수 입력: ");
        int kor = sc.nextInt();
        System.out.print("영어점수 입력: ");
        int eng = sc.nextInt();
        System.out.print("수학점수 입력: ");
        int math = sc.nextInt();

        list.add(new Student(name, kor, eng, math));
    }
    public static void printAll(){
        for (Student student : list) {
            print(student);
        }
    }
    public static void print(Student student){
        int sum = student.eng + student.kor + student.math;
        System.out.printf("이름: %s 국어: %d 영어: %d 수학: %d 총점: %d 평균: %f\n", student.name, student.kor, student.eng, student.math, sum, sum / 3.0);

    }
    public static void search(){
        System.out.print("검색할 사람의 이름: ");
        String name = sc.next();
        for(Student student:list){
            if(student.name.equals(name)) {
                print(student);
                break;
            }
        }
    }
    public static void edit(){
        System.out.print("수정할 사람의 이름: ");
        String name = sc.next();
        Student student = null;
        for(Student s:list){
            if(s.name.equals(name)) {
                student=s;
            }
        }
        if(student==null){
            System.out.println("오류 발생");
            return;
        }
        System.out.print("수정할 내용은? 1.국어 2.영어 3.수학: ");
        int target = sc.nextInt();
        if(target==1){
            System.out.print("국어 점수 수정: ");
            student.kor= sc.nextInt();
        }else if (target==2){
            System.out.print("영어 점수 수정: ");
            student.eng= sc.nextInt();

        } else if (target==3) {
            System.out.print("수학 점수 수정: ");
            student.math= sc.nextInt();

        }else {
            System.out.println("오류 발생");
        }
    }
    public static void delete(){
        System.out.print("삭제할 사람의 이름: ");
        String name = sc.next();
        Student student=null;
        for(Student s:list) {
            if (s.name.equals(name)) {
                student = s;
            }
        }
        if(student==null){
            System.out.println("오류 발생");
            return;
        }
        list.remove(student);
    }

}
