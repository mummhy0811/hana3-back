import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class ex65 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        //설정도 가능
        LocalDate birthday = LocalDate.of(2000, 12, 1); //

        LocalTime time = LocalTime.now();
        System.out.println(time); //10:14:30.133298900

        LocalTime parisTime = LocalTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(parisTime); //02:14:30.135292400

        //시간 계산 API
        LocalTime sleepTime = LocalTime.of(23,30,0);
        LocalTime getupTime = sleepTime.plusHours(8);
        LocalTime inhouseTime = sleepTime.minusHours(5);


        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime); //2024-03-15T10:14:30.138299400
        System.out.println(dateTime.getYear()); //2024
        System.out.println(dateTime.getDayOfWeek()); //FRIDAY
        System.out.println(dateTime.getMonthValue()); //3

        //연습문제
        // 12월 25일에 크리스마스 이벤트를 시작한다.
        // 현재날짜 기준으로 D-Day를 출력하시오.
        // 출력예) "크리스마스까지 D-24일입니다"
        LocalDate christMas = LocalDate.of(2024, 12, 25); //
        LocalDate today = LocalDate.now();
        int left=christMas.getDayOfYear()-today.getDayOfYear();
        System.out.println(left);

    }
}
