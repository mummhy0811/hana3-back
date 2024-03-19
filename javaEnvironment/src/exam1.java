import java.util.Arrays;

public class exam1 {
    public static void main(String[] args) {
        int[] arrayIndex1={2, 0, 1, 3, 4}; //2차 배열의 행 인덱스
        int[] arrayIndex2={1, 2, 0, 4, 3}; //2차 배열의 열 인덱스
        int[][] arrayNum = {
                {22, 92, 32, 42, 52},
                {23, 93, 33, 43, 53},
                {24, 94, 34, 44, 54},
                {25, 95, 35, 45, 55},
                {26, 96, 36, 46, 56}
        };

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        int[] arr=new int[5];
        for(int i=0;i<5;i++){
            int row=arrayIndex1[i];
            int col=arrayIndex2[i];
            arr[i]=arrayNum[row][col];
            min=Math.min(min, arr[i]);
            max=Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        int min_idx=1;
        int max_idx=1;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(arrayNum[i][j]<min) min_idx++;
                if(arrayNum[i][j]>max) max_idx++;
            }
        }

        System.out.println("뽑힌 수들의 배열: "+ Arrays.toString(arr));
        System.out.println("최소값: "+min);
        System.out.println("최대값: "+max);
        System.out.println("최소값 "+min+"은 전체 수에서 "+min_idx+"번째로 작은 수이다.");
        System.out.println("최대값 "+max+"은 전체 수에서 "+max_idx+"번째로 큰 수이다.");
    }
}
