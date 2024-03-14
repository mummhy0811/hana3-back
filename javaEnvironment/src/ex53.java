public class ex53 {
    public static void main(String[] args) {
        //Wrapper Class : 기본 자료형 8개를 감싸서 클래스로 만든 것
        //클래스로 만들어야 다형성 이용 가능
        //기본 자료형: int long short byte char boolean float double
        //래퍼 클래스 Integer Long Short Byte Character Boolean Float Double
        //숫자 클래스: Number - int long short byte float double

        //예외처리
        String name=null;
        try{
            System.out.println(name.toLowerCase());
        }catch(NullPointerException e){
            System.out.println("npe 발생");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("그 외의 예외 발생");
        }
        finally{
            //예외가 있던 없던 실행
            System.out.println("무조건 실행");
        }
    }
}