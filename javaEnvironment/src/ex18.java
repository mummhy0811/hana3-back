import java.util.Scanner;

public class ex18 {
    public static void main(String[] args) {

        int cnt=0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            //소수 판별
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}