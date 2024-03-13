//상속 연습: 부모(상위)클래스의 자산(필드, 메소드)를 자녀(하위)클래스가 물려받는 것.
class Animal{
    int age=10;
    void eat(){
        System.out.println("먹는다");
    }
}
class Dog extends Animal{
    void bark(){
        System.out.println("짖는다");
    }
}
class Cat extends Animal{
    void grooming(){
        System.out.println("손질한다");
    }
}

public class ex36 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.age);
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.grooming();
    }
}
