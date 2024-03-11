public class ex17 {
    public static void main(String[] args) {
        //런타임 디버그
        //print문 만으로 전체 맥락을 파악하기 어려울 때 사용
        //Break Point(중단점) 설정: Crtl+F8
        //스텝 오버(F8): 다음 줄로 이동
        //스텝 인투(F7): 함수 안으로 이동
        //다시 시작(F9): 계속해서 진행(Resume)
        //스텝 아웃(shift+F8): 함수 밖으로 이동
        int[] arr = new int[10];
        for(int i=0;i<10;i++){
            System.out.println(i);
            arr[i]=i;
        }

        myFunc();
    }
    static void myFunc(){
        System.out.println("myFunction!");
    }
}
