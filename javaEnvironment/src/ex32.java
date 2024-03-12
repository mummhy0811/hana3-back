//싱글톤 설명
class UniqueFishBun{
    int bunNo=30;
    private static UniqueFishBun singleton; //null
    static UniqueFishBun getInstance(){
        if(singleton==null){
            singleton=new UniqueFishBun();
        }
        return singleton;
    }
}
public class ex32 {
    public static void main(String[] args) {
        UniqueFishBun uBun1=UniqueFishBun.getInstance();
        UniqueFishBun uBun2=UniqueFishBun.getInstance();
        System.out.println(uBun1);
        System.out.println(uBun2);
    }
}
