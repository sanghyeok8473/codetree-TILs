import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, min = 10000, max = 1, finalSum = 0, sum = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
            sum += nums[i];
        }
        for(int i = min ; i <= max ; i++){  // 동일해지는 값을 미리 지정
            if(i*n == sum){
                for(int j = 0 ; j < n ; j++){
                    if(nums[j] > i)
                        finalSum += nums[j]-i;
                        
                }
            }
        }
        System.out.print(finalSum);
    }
}