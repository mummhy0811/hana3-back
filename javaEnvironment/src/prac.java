import java.util.Scanner;

public class prac {
    public static void main(String[] args) {
//        //별찍기 - 이중반복문
//        //어떤 수 n을 입력받으면 다음과 같은 삼각형을 출력한다.
//        //여기서 입력되는 n은 반드시 홀수이다.
//        //입력
//        //3부터 99 까지의 홀수 중 하나가 입력된다.
//        //5
//        //출력
//        //  *
//        // ***
//        //*****
//
//        //별찍기
//        //정방형 별찍기 3x3 5x5 7x7
//        //*****
//        //*****
//        //*****
//        //*****
//        //*****
//        for(int i=0; i<5; i++){
//            for(int j=0; j<5; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        //*
//        //**
//        //***
//        //****
//        //*****
//        for(int i=0; i<5; i++){
//            for(int j=0; j<i+1; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        //    * //공백4, 별1
//        //   ** //공백3, 별2
//        //  *** //공백2, 별3
//        // ****
//        //*****
//        for(int i=0; i<5; i++){
//            for(int j=0; j<4-i; j++){
//                System.out.print(" ");
//            }
//            for(int j=0; j<i+1; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        //5     : i=3  k = n/2+1
//        //  *   : i=0, 공백2(k-i-1), 별1(i*2+1)
//        // ***  : i=1, 공백1(k-i-1), 별3(i*2+1)
//        //***** : i=2, 공백0(k-i-1), 별5(i*2+1)
//        int n = 5;
//        int k = n/2+1;
//        for(int i=0; i<k; i++){
//            for(int j=0; j<k-i-1; j++){
//                System.out.print(" ");
//            }
//            for(int j=0; j<i*2+1; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
        //연습문제
        //입력 n의 값에 따라 다음을 출력하시오.
        //입력
        //3
        // *
        //***
        // *
        //5
        //  *
        // ***
        //*****
        // ***
        //  *
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int k = n/2+1;
        for(int i=0; i<n; i++){
            if(i<k){
                for(int j=0; j<k-i-1; j++){
                    System.out.print(" ");
                }
                for(int j=0; j<i*2+1; j++){
                    System.out.print("*");
                }
                System.out.println();
            }else{
                for(int j=0; j<=i%k; j++){
                    System.out.print(" ");
                }
                for(int j=1; j<n-((i%k)*2)-1; j++){
                    System.out.print("*");
                }
                System.out.println();
            }

        }

    }
}