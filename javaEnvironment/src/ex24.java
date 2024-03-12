public class ex24 {
    public static void main(String[] args) {
        //2차원 배열
        int[][] arr =new int[2][3];

        //열의 길이 나중에 설정
        int[][] arr2=new int[2][];
        arr2[0]=new int[3];
        arr2[1]=new int[2];
        System.out.println(arr2.length); //행의 길이
        System.out.println(arr2[0].length); //1열의 길이

        int[][] arr3={{1, 2, 3},{4, 5, 6}};
        int arr4[][]={{1, 2, 3},{4, 5, 6}};

        //연습문제
        //1. 2차원 정수배열 nums를 행 3개, 열 3개로 만들고,
        // 모든 행열에 값을 넣되,
        // 랜덤값 정수 1~100 사이의 값을 넣고,
        // 전체를 순환하여 출력하시오.
        //2. 최소값과 최대값을 출력하시오.

        int[][]nums = new int[3][3];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                nums[i][j]=(int) ((Math.random() * 10000)%100+1);
                System.out.print(nums[i][j]+" ");
                min=Math.min(min, nums[i][j]);
                max=Math.max(max, nums[i][j]);
            }
            System.out.println();
        }
        System.out.println("최소, 최대: "+min+", "+max);
        //3.
        // 순돌이네 인쇄소
        // 3x3 2차원 정수배열에 아래와 같은 숫자가 들어있다면,
        // 0 1 0       #  *  #
        // 1 2 0   =>  *  +  #
        // 1 0 0       *  #  #
        // 이렇게 출력이 된다.
        // 0 1 2
        // 1 2 0
        // 2 1 0 이렇게 들어가 있을때 출력결과를 표시하시오.
        int[][] data = { {0, 1, 2},
                {1, 2, 0},
                {2, 1, 0} };
        for (int[] datum : data) {
            for (int target : datum) {
                if (target == 0) System.out.print("# ");
                else if (target == 1) System.out.print("* ");
                else if (target == 2) System.out.print("+ ");
            }
            System.out.println();
        }
    }
}
