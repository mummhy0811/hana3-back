//연습문제 - 싱글톤 만들기
//클래스 이름 : HanaAccount
//  필드 : 계좌번호(1234), 고객이름(홍길동), 잔액(1000), 이자율(년3%)
//  메소드 : put(+100), 출금(-100), 이자계산(1년후 잔액), 잔액조회

class HanaAccount{
    private int account;
    private String name;
    private double left;
    private double interest_rate;
    private static HanaAccount singleton;
    static HanaAccount getInstance(){
        if(singleton==null){
            singleton=new HanaAccount();
        }
        return singleton;
    }
    public void put(){
        this.left+=100;
    }
    public void extract(){
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
public class ex33 {
    public static void main(String[] args) {
        //싱글톤을 호출후
        //1. 입금 메소드 호출
        //2. 출금 메소드 호출
        //3. 이자계산은 이자율을 읽어서 참조한다.
        //   이자계산후 잔액 증가한다.
        //4. 최종 잔액을 출력한다.
        HanaAccount hanaAccount = HanaAccount.getInstance();

        hanaAccount.setAccount(1234);
        hanaAccount.setLeft(1000);
        hanaAccount.setName("홍길동");
        hanaAccount.setInterest_rate(0.03);

        hanaAccount.put();
        hanaAccount.extract();
        hanaAccount.calc_interest();
        System.out.println(hanaAccount.getLeft());
    }
}