//중첩 클래스: 클래스 안에 클래스
//외부(outer)클래스: 클래스 밖에 클래스 선언
//내부(inner)클래스: 클래스 안에 클래스 선언
//내부 클래스 사용 이유: 내부적으로 소비하고 끝나는 클래스를 위해.

class Outer{
    String name="outer";
    class Inner{
        String name="inner";
    }
    static class InnerStatic{

    }
}
public class ex50 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer);
        Outer.Inner inner = outer.new Inner();
        System.out.println(inner.name);
    }
}

