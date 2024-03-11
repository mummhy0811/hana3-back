import java.util.Scanner;

public class ex19 {
    public static void main(String[] args) {

        //연습문제 - 별찍기
        //1. 다음과 같이 출력하시오.
        // 입력 예)
        // 5
        // 출력 예)
        //*****
        //*****
        //*****
        //*****
        //*****

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //2. 별찍기2
        //입력 예)
        //5
        //출력 예)
        //    *
        //   **
        //  ***
        // ****
        //*****
        for(int i=1;i<=n;i++){
            for(int j=n;j>0;j--){
                if(i<j) {
                    System.out.print(" ");
                }
                else System.out.print("*");
            }
            System.out.println();
        }
        //2. 별찍기3
        //입력 예) 5이상의 홀수
        //5
        //출력 예)
        //*****
        //*  **
        //* * *
        //**  *
        //*****
        //입력 예)
        //7
        //출력 예)
        //*******
        //*    **
        //*   * *
        //*  *  *
        //* *   *
        //**    *
        //*******
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == n) {
                for (int j = 0; j < n; j++) System.out.print("*");
                System.out.println();
                continue;
            }
            for (int j = n; j > 0; j--) {
                if (j == 1 || j == n || i == j) {
                    System.out.print("*");
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}