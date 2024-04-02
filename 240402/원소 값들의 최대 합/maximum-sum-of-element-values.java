import java.util.Scanner;

public class Main {
    public static int n, m, nowSum, maxSum = 0;
    public static int[] nums = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt();
        for(int i = 1 ; i <= n ; i++)
            nums[i] = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){      // 시작위치
            nowSum = 0; int idx = i;
            for(int j = 0 ; j < m ; j++){   // 반복횟수
                nowSum += nums[idx];
                idx = nums[idx];
            }
            maxSum = Math.max(maxSum, nowSum);
        }


        
        System.out.print(maxSum);

        

    }
}