import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, min = 10000, max = 1, finalMin = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        for(int i = min ; i <= max ; i++){  // 동일해지는 값을 미리 지정
            int nowSum = 0;
            for(int j = 0 ; j < n ; j++){
                nowSum += Math.abs(nums[j] - i);
            }
            finalMin = Math.min(nowSum, finalMin);
        }
        System.out.print(finalMin/2);
    }
}