public class ex15 {
    public static void main(String[] args) {

        //연습문제 - switch문 연습
        //애완견 똘이를 기쁘게 해줄 애완용 로봇을 프로그램해보자.
        // 코드 0를 입력하면 "음악을 틀어준다."콘솔 출력
        // 코드 1 : 간식을 준다.
        // 코드 2 : 주인의 영상을 틀어준다.
        // 코드 3 : 산책을 시켜준다.
        // 그외의 코드 : 잘못된 코드입니다. 출력
        //랜덤수(코드)를 0~5까지 발생시켜, 코드에 맞는 출력문을
        //작성하시오.
        int a = (int) ((Math.random() * 10000) % 6);
        System.out.println(a);
        switch ( a ) {
            case 0:
                System.out.println("음악을 틀어준다.");
                break;
            case 1:
                System.out.println("간식을 준다.");
                break;
            case 2:
                System.out.println("주인의 영상을 틀어준다.");
                break;
            case 3:
                System.out.println("산책을 시켜준다.");
                break;
            default:
                System.out.println("잘못된 코드입니다.");
                break;
        }


        //2.
        //달을 나타내는 랜덤수 1~12까지의 정수를 발생시켜,
        //3,4,5이면 봄
        //6,7,8이면 여름
        //9,10,11이면 가을
        //12,1,2이면 겨울 이라고 출력하시오.
        int month = (int) ((Math.random() * 10000) % 12+1);
        System.out.println(month);
        switch ( month ) {
            case 3:
            case 4:
            case 5:
                System.out.println("봄");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("가을");
                break;
            default:
                System.out.println("겨울");
                break;
        }
    }
}