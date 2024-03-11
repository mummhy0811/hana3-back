public class ex16 {
    public static void main(String[] args) {
        //연습문제
        //1. 1부터 100까지 3과 5의 배수인 수만 출력하시오.
        for(int i=1;i<=100;i++){
            if(i%3==0 || i%5==0) System.out.println(i);
        }

        //2. 1부터 10까지의 합을 출력하시오.
        int sum=0;
        for(int i=0;i<=10;i++){
            sum+=i;
        }
        System.out.println(sum);

        //3. 1부터 100까지 끝자리가 3으로 끝나는 수의 갯수(count)를 출력하시오.
        int cnt=0;
        for(int i=1;i<=100;i++){
            if(i%10==3){
                cnt++;
            }
        }
        System.out.println(cnt);

        //4.
        //영희가 1부터 100까지 번호가 쓰인 징검다리 돌을 지나고 있다.
        //뒷자리가 2나 7로 된 돌은 밣지 않고 건너려고 한다.
        //영희가 밣은 벽돌의 갯수와 밣지 않은 벽돌의 갯수를 출력하시오.
        int step=0;
        int notStep=0;
        for(int i=1;i<=100;i++){
            if(i%10==2 || i%10==7) notStep++;
            else step++;
        }
        System.out.printf("영희가 밟은 벽돌의 갯수: %d\n", step);
        System.out.printf("밟지 않은 벽돌의 갯수: %d", notStep);
    }
}
