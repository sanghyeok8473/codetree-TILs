import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, m, cnt = 0, nowCnt = 0, max = 1, finalMin = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        //제일 작은수 : A, 제일 큰수 : A+B+C
        // 즉 max - min = B+C
        //크기 순 : A+B+C, C+B, C+A, A+B, C, B, A
        //오름차순 : (A, B), C, A+B, A+C, (B+C, A+B+C)
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[7];

        for(int i = 0 ; i < 7 ; i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        int bc = nums[6] - nums[0]; // B+C;
        int  c = bc - nums[1];
        System.out.print(nums[0]+" "+nums[1]+" "+c);
    }
    
}