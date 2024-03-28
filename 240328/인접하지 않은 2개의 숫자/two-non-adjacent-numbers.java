import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), max = 0;

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++)
            arr[i] = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(Math.abs(j-i) > 1){
                    int nowSum = arr[i]+arr[j];
                    if(nowSum > max)
                        max = nowSum;
                }
            } // 0 2일때도 비교하고, 2 0일때도 비교해서 직접 셀 때보다 두 배 더 많이 돌지만, 절대값으로 이해가 편함. i와 j의 범위를 적절히 조절 하면 변경가능.
        }
        System.out.print(max);
    }
}