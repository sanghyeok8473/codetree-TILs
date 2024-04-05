import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, k, minCost = 10000*100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); k = sc.nextInt();

        int[] nums = new int[n];
        
        for(int i = 0 ; i < n ; i++)
            nums[i] = sc.nextInt();

        for(int min = 1 ; min <= 10000 ; min++){ // 미리 설정해보는 최솟값.
            int max = min + k, nowCost = 0;
            for(int i = 0 ; i < n ; i++){
                if(nums[i] > max)            
                    nowCost += nums[i] - max;
                if(nums[i] < min){  
                    nowCost += min - nums[i];
                }
            }
            minCost = Math.min(minCost, nowCost);
        }
        System.out.print(minCost);

    }
}