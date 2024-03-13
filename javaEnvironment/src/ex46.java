interface Drawing{
    //void sale(){ } //일반 함수 선언 불가
    //가상함수만 선언 가능, abstract는 써도 되로, 안 써도 됨
    abstract void draw();
    void sketch();
}
class Painter implements Drawing{
    @Override
    public void draw() {

    }

    @Override
    public void sketch() {

    }

    ;
}
public class ex46 {
    public static void main(String[] args) {
        Painter p = new Painter();
        p.draw();
        p.sketch();

    }
}
