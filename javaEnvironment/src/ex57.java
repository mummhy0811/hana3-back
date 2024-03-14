class Account{
    private int account;
    private String name;
    private double left;
    private double interest_rate;
    private static Account singleton;
    static Account getInstance(){
        if(singleton==null){
            singleton=new Account();
        }
        return singleton;
    }
    public void put(){
        this.left+=100;
    }
    public void extract() throws Exception{
        if(this.left-100<0){
            OverdrawnException e = new OverdrawnException();
            e.message="잔액이 부족합니다.";
            throw e;
        }
        this.left-=100;
    }
    public void calc_interest(){
        this.left+= (int) (this.left*0.03);
    }
    public double getLeft() {
        return left;
    }
    public void setAccount(int account) {
        this.account = account;
    }
    public void setLeft(int left) {
        this.left = left;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }

}
public class ex57 {
    public static void main(String[] args) {
        Account hanaAccount = Account.getInstance();

        try{
            hanaAccount.setAccount(1234);
            hanaAccount.setLeft(50);
            hanaAccount.setName("홍길동");
            hanaAccount.extract();

        }catch (Exception e){
            OverdrawnException oe = (OverdrawnException)e;
            oe.printMessage();
        }

    }
}

//사용자 정의 예외
class OverdrawnException extends Exception{
    String message="";
    public void printMessage(){
        System.out.println(this.message);
    }
}
