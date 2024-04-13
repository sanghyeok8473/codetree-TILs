import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, m, diffMin = 1000000000;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        int[] nums = new int[2*n];

        for(int i = 0 ; i < 2*n ; i++)
            nums[i] = sc.nextInt();
        

        Arrays.sort(nums);

        for(int i = 0 ; i < n ; i++){
            diffMin = Math.min(diffMin, (nums[i+n] - nums[i]));
        }

        System.out.print(diffMin);
    }
}