class Keyboard1{
    private Object object; //다형성을 이용한 모든 클래스 객체를 넣을 수 있음

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
class Keyboard2 <MyType>{
    private MyType object;

    public MyType getObject() {
        return object;
    }

    public void setObject(MyType object) {
        this.object = object;
    }

}
public class ex63 {
    public static void main(String[] args) {
        Keyboard1 k1 = new Keyboard1();
        k1.setObject("키보드1");
        String str = (String)k1.getObject(); // 다운캐스팅

        Keyboard2<String> k2 = new Keyboard2<>();
        k2.setObject("키보드2");
        String str2 = k2.getObject(); // 다운캐스팅 안 해도 됨.
    }
}
