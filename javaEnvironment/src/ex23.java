public class ex23 {
    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;

        int[] a2 = new int[]{1, 2, 3};

        int[] a3 = {1, 2, 3};

        int a4[] = {1, 2, 3};

        //불가능
        //int[]a5;
        //a={1, 2, 3};

        //연습문제
        int[] nums={10, 30, 20, 50, 40};
        //1. 배열의 모든 요소값를 출력하시오.
        //2. 배열의 값 갯수를 출력하시오.
        //3. 배열의 모든 값의 합계를 출력하시오.
        //4. 배열에서 20은 몇번째에 위치하는지 출력하시오.
        //   출력값: 3번째
        int sum=0;
        int index=-1;
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
            sum+=nums[i];
            if(nums[i]==20) index=i+1;
        }
        System.out.println(nums.length);
        System.out.println(sum);
        System.out.println(index+"번째");
    }
}
