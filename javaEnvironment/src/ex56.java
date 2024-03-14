public class ex56 {
    public static void main(String[] args){
        try{
            myFunc();
        }catch (Exception e){ //4. 예외 받음
            MyException e2 = (MyException) e; //다운캐스팅을 통해 exception 받음
            e2.printMessage(); //예외 출력
        }


    }
    static void myFunc() throws Exception{ // 예외를 떠넘김
        System.out.println("myFunc");
//        System.out.println(10/0);

        int i=2;
        if(i<20){ //1. 예외가 발생해야 하는 상황
//            throw new MyException();
            MyException e = new MyException(); //2. 예외 객체 생성
            e.message="!!!!!!!!사용자 예외!!!!!";
            throw e; //3. 예외 발생
        }
    }

}
//사용자 정의 예외
class MyException extends Exception{
    String message="";
    public void printMessage(){
        System.out.println(this.message);
    }
}