import javax.swing.*;

class People{
    void think(){
        System.out.println("생각한다");
    }
}
class Man extends People{
    @Override
    void think(){
        System.out.println("남자가 생각한다");
    }
    void shave(){
        System.out.println("면도한다");
    }
}
class Woman extends People{
    @Override
    void think(){
        System.out.println("여자가 생각한다");
    }
    void makeup(){
        System.out.println("화장한다");
    }
}
public class ex44 {
    public static void main(String[] args) {
        //업캐스팅 - 자식이 부모 클래스 객체를 가짐
        People people = new Man();
        people.think(); //남자가 생각한다.

        myFunc(new Man());
    }

    static void myFunc(People people){ // 다형성: 부모인 People을 받음으로써 자식인 Man과 Woman을 모두 받을 수 있음
        if(people instanceof Man) //instanceof -> 타입을 확인
            ((Man)people).shave();
        else if(people instanceof Woman)
            ((Woman)people).makeup();
    }
}
