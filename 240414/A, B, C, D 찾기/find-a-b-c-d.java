import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int[] nums = new int[15];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < 15 ; i++)
            nums[i] = sc.nextInt();
        
        Arrays.sort(nums);

        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        int d = nums[14] - a - b - c;
        System.out.print(a+" "+b+" "+c+" "+d);

        
    }
}